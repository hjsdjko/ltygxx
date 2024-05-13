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

import com.entity.ZhaopinEntity;

import com.service.ZhaopinService;
import com.entity.view.ZhaopinView;
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
@RequestMapping("/zhaopin")
public class ZhaopinController {
    private static final Logger logger = LoggerFactory.getLogger(ZhaopinController.class);

    @Autowired
    private ZhaopinService zhaopinService;


    @Autowired
    private TokenService tokenService;


    //级联表service

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
    PageUtils page = zhaopinService.queryPage(params);

    //字典表数据转换
    List<ZhaopinView> list =(List<ZhaopinView>)page.getList();
        ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        dictionaryMap = (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        for(ZhaopinView c:list){
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
        ZhaopinEntity zhaopin = zhaopinService.selectById(id);
        if(zhaopin !=null){
            //entity转view
            ZhaopinView view = new ZhaopinView();
            BeanUtils.copyProperties( zhaopin , view );//把实体数据重构到view中

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
    public R save(@RequestBody ZhaopinEntity zhaopin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhaopin:{}",this.getClass().getName(),zhaopin.toString());
        Wrapper<ZhaopinEntity> queryWrapper = new EntityWrapper<ZhaopinEntity>()
            .eq("name", zhaopin.getName())
            .eq("id_number", zhaopin.getIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhaopinEntity zhaopinEntity = zhaopinService.selectOne(queryWrapper);
        if(zhaopinEntity==null){
            zhaopin.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      zhaopin.set
        //  }
            zhaopinService.insert(zhaopin);
            return R.ok();
        }else {
            return R.error(511,"此人员已经被录入招聘列表中");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhaopinEntity zhaopin, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhaopin:{}",this.getClass().getName(),zhaopin.toString());
        //根据字段查询是否有相同数据
        Wrapper<ZhaopinEntity> queryWrapper = new EntityWrapper<ZhaopinEntity>()
            .notIn("id",zhaopin.getId())
            .eq("name", zhaopin.getName())
            .eq("id_number", zhaopin.getIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhaopinEntity zhaopinEntity = zhaopinService.selectOne(queryWrapper);
        if("".equals(zhaopin.getMyPhoto()) || "null".equals(zhaopin.getMyPhoto())){
                zhaopin.setMyPhoto(null);
        }
        if(zhaopinEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      zhaopin.set
            //  }
            zhaopinService.updateById(zhaopin);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该人员姓名 手机号 身份证号 已经录入过招聘网站中");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zhaopinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    *字典表数据转换
    */
    public void dictionaryConvert(ZhaopinView zhaopinView){
        //当前表的字典字段
        if(StringUtil.isNotEmpty(String.valueOf(zhaopinView.getSexTypes()))){
            zhaopinView.setSexValue(dictionaryMap.get("sex_types").get(zhaopinView.getSexTypes()));
        }
        if(StringUtil.isNotEmpty(String.valueOf(zhaopinView.getEducationTypes()))){
            zhaopinView.setEducationValue(dictionaryMap.get("education_types").get(zhaopinView.getEducationTypes()));
        }

        //级联表的字典字段
    }


}

