package com.dao;

import com.entity.ZhaopinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhaopinView;

/**
 * 招聘信息 Dao 接口
 *
 * @author 
 * @since 2021-03-01
 */
public interface ZhaopinDao extends BaseMapper<ZhaopinEntity> {

   List<ZhaopinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
