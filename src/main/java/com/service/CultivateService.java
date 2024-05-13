package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CultivateEntity;
import java.util.Map;

/**
 * 考勤 服务类
 * @author 
 * @since 2021-03-01
 */
public interface CultivateService extends IService<CultivateEntity> {

     PageUtils queryPage(Map<String, Object> params);

}