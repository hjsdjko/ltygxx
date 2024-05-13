package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MianshiEntity;
import java.util.Map;

/**
 * 招聘信息 服务类
 * @author 
 * @since 2021-03-01
 */
public interface MianshiService extends IService<MianshiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}