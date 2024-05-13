package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.MianshiEntity;

import com.service.MianshiService;
import com.entity.view.MianshiView;
import com.service.ZhaopinService;
import com.entity.ZhaopinEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 招聘信息
 * 后端接口
 * @author
 * @email
 * @date 2021-03-01
*/
@RestController
@Controller
@RequestMapping("/mianshi")
public class MianshiController {
    private static final Logger logger = LoggerFactory.getLogger(MianshiController.class);

    @Autowired
    private MianshiService mianshiService;


    @Autowired
    private TokenService tokenService;


    //级联表service
    @Autowired
    private ZhaopinService zhaopinService;

    //字典表map
    Map<String, Map<Integer, String>> dictionaryMap;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
    logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
    PageUtils page = mianshiService.queryPage(params);

    //字典表数据转换
    List<MianshiView> list =(List<MianshiView>)page.getList();
        ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        dictionaryMap = (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        for(MianshiView c:list){
        this.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MianshiEntity mianshi = mianshiService.selectById(id);
        if(mianshi !=null){
            //entity转view
            MianshiView view = new MianshiView();
            BeanUtils.copyProperties( mianshi , view );//把实体数据重构到view中

            //级联表
            ZhaopinEntity zhaopin = zhaopinService.selectById(mianshi.getZhaopinId());
            if(zhaopin != null){
                BeanUtils.copyProperties( zhaopin , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setZhaopinId(zhaopin.getId());
            }
            //字典表字典转换
            ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
            dictionaryMap = (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
            this.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody MianshiEntity mianshi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,mianshi:{}",this.getClass().getName(),mianshi.toString());
        Wrapper<MianshiEntity> queryWrapper = new EntityWrapper<MianshiEntity>()
            .eq("zhaopin_id", mianshi.getZhaopinId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MianshiEntity mianshiEntity = mianshiService.selectOne(queryWrapper);
        if(mianshiEntity==null){
            mianshi.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      mianshi.set
        //  }
            mianshiService.insert(mianshi);
            return R.ok();
        }else {
            return R.error(511,"该招聘人员已经约过面试时间了,请去面试记录中查看详情");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MianshiEntity mianshi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,mianshi:{}",this.getClass().getName(),mianshi.toString());
        //根据字段查询是否有相同数据
        Wrapper<MianshiEntity> queryWrapper = new EntityWrapper<MianshiEntity>()
            .notIn("id",mianshi.getId())
            .eq("zhaopin_id", mianshi.getZhaopinId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MianshiEntity mianshiEntity = mianshiService.selectOne(queryWrapper);
        if(mianshiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      mianshi.set
            //  }
            mianshiService.updateById(mianshi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        if(ids !=null){
            List<Integer> idList = Arrays.asList(ids);
            List<MianshiEntity> m = mianshiService.selectBatchIds(idList);
            List<Integer> l = new ArrayList<>();
            if(m!=null && m.size()>0){
                for(MianshiEntity a:m){
                    l.add(a.getZhaopinId());
                }
            }
            /**
             * 删除招聘表数据
             */
            if(l != null && l.size()>0){
                zhaopinService.deleteBatchIds(l);
            }
            //删除面试表数据
            mianshiService.deleteBatchIds(Arrays.asList(ids));
        }
        return R.ok();
    }

    /**
    *字典表数据转换
    */
    public void dictionaryConvert(MianshiView mianshiView){
        //当前表的字典字段
        if(StringUtil.isNotEmpty(String.valueOf(mianshiView.getMianshiTypes()))){
            mianshiView.setMianshiValue(dictionaryMap.get("mianshi_types").get(mianshiView.getMianshiTypes()));
        }

        //级联表的字典字段
        if(StringUtil.isNotEmpty(String.valueOf(mianshiView.getSexTypes()))){
            mianshiView.setSexValue(dictionaryMap.get("sex_types").get(mianshiView.getSexTypes()));
        }
        if(StringUtil.isNotEmpty(String.valueOf(mianshiView.getEducationTypes()))){
            mianshiView.setEducationValue(dictionaryMap.get("education_types").get(mianshiView.getEducationTypes()));
        }
    }


}

