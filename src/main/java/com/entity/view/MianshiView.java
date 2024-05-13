package com.entity.view;

import com.entity.MianshiEntity;

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
@TableName("mianshi")
public class MianshiView extends MianshiEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 面试结果的值
		*/
		private String mianshiValue;



		//级联表 zhaopin
			/**
			* 姓名
			*/
			private String name;
			/**
			* 手机号
			*/
			private String phone;
			/**
			* 身份证号
			*/
			private String idNumber;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 照片
			*/
			private String myPhoto;
			/**
			* 学历
			*/
			private Integer educationTypes;
				/**
				* 学历的值
				*/
				private String educationValue;
			/**
			* 毕业学校
			*/
			private String school;

	public MianshiView() {

	}

	public MianshiView(MianshiEntity mianshiEntity) {
		try {
			BeanUtils.copyProperties(this, mianshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 面试结果的值
			*/
			public String getMianshiValue() {
				return mianshiValue;
			}
			/**
			* 设置： 面试结果的值
			*/
			public void setMianshiValue(String mianshiValue) {
				this.mianshiValue = mianshiValue;
			}












				//级联表的get和set zhaopin
					/**
					* 获取： 姓名
					*/
					public String getName() {
						return name;
					}
					/**
					* 设置： 姓名
					*/
					public void setName(String name) {
						this.name = name;
					}
					/**
					* 获取： 手机号
					*/
					public String getPhone() {
						return phone;
					}
					/**
					* 设置： 手机号
					*/
					public void setPhone(String phone) {
						this.phone = phone;
					}
					/**
					* 获取： 身份证号
					*/
					public String getIdNumber() {
						return idNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setIdNumber(String idNumber) {
						this.idNumber = idNumber;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
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
					* 获取： 照片
					*/
					public String getMyPhoto() {
						return myPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setMyPhoto(String myPhoto) {
						this.myPhoto = myPhoto;
					}
					/**
					* 获取： 学历
					*/
					public Integer getEducationTypes() {
						return educationTypes;
					}
					/**
					* 设置： 学历
					*/
					public void setEducationTypes(Integer educationTypes) {
						this.educationTypes = educationTypes;
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
					/**
					* 获取： 毕业学校
					*/
					public String getSchool() {
						return school;
					}
					/**
					* 设置： 毕业学校
					*/
					public void setSchool(String school) {
						this.school = school;
					}






}
