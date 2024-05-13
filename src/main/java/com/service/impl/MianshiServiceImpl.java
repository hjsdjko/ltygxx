package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.MianshiDao;
import com.entity.MianshiEntity;
import com.service.MianshiService;
import com.entity.view.MianshiView;

/**
 * 招聘信息 服务实现类
 * @author 
 * @since 2021-03-01
 */
@Service("mianshiService")
@Transactional
public class MianshiServiceImpl extends ServiceImpl<MianshiDao, MianshiEntity> implements MianshiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<MianshiView> page =new Query<MianshiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
