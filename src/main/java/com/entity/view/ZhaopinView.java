package com.entity.view;

import com.entity.ZhaopinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 招聘信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-01
 */
@TableName("zhaopin")
public class ZhaopinView extends ZhaopinEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 性别的值
		*/
		private String sexValue;
		/**
		* 学历的值
		*/
		private String educationValue;



	public ZhaopinView() {

	}

	public ZhaopinView(ZhaopinEntity zhaopinEntity) {
		try {
			BeanUtils.copyProperties(this, zhaopinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
			}
			/**
			* 获取： 学历的值
			*/
			public String getEducationValue() {
				return educationValue;
			}
			/**
			* 设置： 学历的值
			*/
			public void setEducationValue(String educationValue) {
				this.educationValue = educationValue;
			}










}
