package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhaopinEntity;
import java.util.Map;

/**
 * 招聘信息 服务类
 * @author 
 * @since 2021-03-01
 */
public interface ZhaopinService extends IService<ZhaopinEntity> {

     PageUtils queryPage(Map<String, Object> params);

}