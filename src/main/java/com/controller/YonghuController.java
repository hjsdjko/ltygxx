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

import com.entity.YonghuEntity;

import com.service.YonghuService;
import com.entity.view.YonghuView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 员工
 * 后端接口
 * @author
 * @email
 * @date 2021-03-01
*/
@RestController
@Controller
@RequestMapping("/yonghu")
public class YonghuController {
    private static final Logger logger = LoggerFactory.getLogger(YonghuController.class);

    @Autowired
    private YonghuService yonghuService;


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
    PageUtils page = yonghuService.queryPage(params);

    //字典表数据转换
    List<YonghuView> list =(List<YonghuView>)page.getList();
        ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        dictionaryMap = (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        for(YonghuView c:list){
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
        YonghuEntity yonghu = yonghuService.selectById(id);
        if(yonghu !=null){
            //entity转view
            YonghuView view = new YonghuView();
            BeanUtils.copyProperties( yonghu , view );//把实体数据重构到view中

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
    public R save(@RequestBody YonghuEntity yonghu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yonghu:{}",this.getClass().getName(),yonghu.toString());
        Wrapper<YonghuEntity> queryWrapper = new EntityWrapper<YonghuEntity>()
            .eq("name", yonghu.getName())
            .eq("id_number", yonghu.getIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YonghuEntity yonghuEntity = yonghuService.selectOne(queryWrapper);
        if(yonghuEntity==null){
            yonghu.setCreateTime(new Date());
            yonghu.setPassword("123456");
//              String role = String.valueOf(request.getSession().getAttribute("role"));
//              if("用户".equals(role)){
//                  yonghu.setZhuangtaiTypes(1);//如果是用户保存的话  状态设置为注册,管理员可以审核
//              }
            yonghuService.insert(yonghu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YonghuEntity yonghu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yonghu:{}",this.getClass().getName(),yonghu.toString());
        //根据字段查询是否有相同数据
        Wrapper<YonghuEntity> queryWrapper = new EntityWrapper<YonghuEntity>()
            .notIn("id",yonghu.getId())
            .eq("username", yonghu.getUsername())
            .eq("password", yonghu.getPassword())
            .eq("name", yonghu.getName())
            .eq("phone", yonghu.getPhone())
            .eq("bumen_types", yonghu.getBumenTypes())
            .eq("zhiwei_types", yonghu.getZhiweiTypes())
            .eq("id_number", yonghu.getIdNumber())
            .eq("sex_types", yonghu.getSexTypes())
            .eq("nation", yonghu.getNation())
            .eq("politics_types", yonghu.getPoliticsTypes())
            .eq("residence", yonghu.getResidence())
            .eq("birthplace", yonghu.getBirthplace())
            .eq("marriage_types", yonghu.getMarriageTypes())
            .eq("education_types", yonghu.getEducationTypes())
            .eq("school", yonghu.getSchool())
            .eq("zhuangtai_types", yonghu.getZhuangtaiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YonghuEntity yonghuEntity = yonghuService.selectOne(queryWrapper);
        if("".equals(yonghu.getMyPhoto()) || "null".equals(yonghu.getMyPhoto())){
                yonghu.setMyPhoto(null);
        }
        if(yonghuEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      yonghu.set
            //  }
            yonghuService.updateById(yonghu);//根据id更新
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
        yonghuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    *字典表数据转换
    */
    public void dictionaryConvert(YonghuView yonghuView){
        //当前表的字典字段
        if(StringUtil.isNotEmpty(String.valueOf(yonghuView.getBumenTypes()))){
            yonghuView.setBumenValue(dictionaryMap.get("bumen_types").get(yonghuView.getBumenTypes()));
        }
        if(StringUtil.isNotEmpty(String.valueOf(yonghuView.getZhiweiTypes()))){
            yonghuView.setZhiweiValue(dictionaryMap.get("zhiwei_types").get(yonghuView.getZhiweiTypes()));
        }
        if(StringUtil.isNotEmpty(String.valueOf(yonghuView.getSexTypes()))){
            yonghuView.setSexValue(dictionaryMap.get("sex_types").get(yonghuView.getSexTypes()));
        }
        if(StringUtil.isNotEmpty(String.valueOf(yonghuView.getPoliticsTypes()))){
            yonghuView.setPoliticsValue(dictionaryMap.get("politics_types").get(yonghuView.getPoliticsTypes()));
        }
        if(StringUtil.isNotEmpty(String.valueOf(yonghuView.getMarriageTypes()))){
            yonghuView.setMarriageValue(dictionaryMap.get("marriage_types").get(yonghuView.getMarriageTypes()));
        }
        if(StringUtil.isNotEmpty(String.valueOf(yonghuView.getEducationTypes()))){
            yonghuView.setEducationValue(dictionaryMap.get("education_types").get(yonghuView.getEducationTypes()));
        }
        if(StringUtil.isNotEmpty(String.valueOf(yonghuView.getZhuangtaiTypes()))){
            yonghuView.setZhuangtaiValue(dictionaryMap.get("zhuangtai_types").get(yonghuView.getZhuangtaiTypes()));
        }

        //级联表的字典字段
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @PostMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
    YonghuEntity yonghu = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("username", username));
        if(yonghu==null || !yonghu.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }else if(yonghu.getZhuangtaiTypes().intValue() !=2){
            return R.error("您不是在职人员,请联系管理员");
        }
        String token = tokenService.generateToken(yonghu.getId(),username, "yonghu", "用户");
        R r = R.ok();
        r.put("token", token);
        r.put("role","用户");
        r.put("userId",yonghu.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody YonghuEntity yonghu){
    //    	ValidatorUtils.validateEntity(user);
        if(yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("username", yonghu.getUsername()).orNew().eq("name",yonghu.getName()).orNew().eq("id_number",yonghu.getIdNumber())) !=null) {
            return R.error("用户已存在");
        }
        yonghu.setZhuangtaiTypes(1);
        yonghu.setCreateTime(new Date());
        yonghuService.insert(yonghu);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrYonghu(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        YonghuEntity yonghu = yonghuService.selectById(id);
        return R.ok().put("data", yonghu);
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }

}

