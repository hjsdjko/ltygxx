package com.entity.view;

import com.entity.QingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 请假
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-01
 */
@TableName("qingjia")
public class QingjiaView extends QingjiaEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 请假状态的值
		*/
		private String qingjiaValue;



		//级联表 yonghu
			/**
			* 账户
			*/
			private String username;
			/**
			* 密码
			*/
			private String password;
			/**
			* 姓名
			*/
			private String name;
			/**
			* 手机号
			*/
			private String phone;
			/**
			* 部门
			*/
			private Integer bumenTypes;
				/**
				* 部门的值
				*/
				private String bumenValue;
			/**
			* 职位
			*/
			private Integer zhiweiTypes;
				/**
				* 职位的值
				*/
				private String zhiweiValue;
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
			* 民族
			*/
			private String nation;
			/**
			* 政治面貌
			*/
			private Integer politicsTypes;
				/**
				* 政治面貌的值
				*/
				private String politicsValue;
			/**
			* 居住地
			*/
			private String residence;
			/**
			* 籍贯(身份证上地址)
			*/
			private String birthplace;
			/**
			* 婚姻状况
			*/
			private Integer marriageTypes;
				/**
				* 婚姻状况的值
				*/
				private String marriageValue;
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
			/**
			* 审核
			*/
			private Integer zhuangtaiTypes;
				/**
				* 审核的值
				*/
				private String zhuangtaiValue;

	public QingjiaView() {

	}

	public QingjiaView(QingjiaEntity qingjiaEntity) {
		try {
			BeanUtils.copyProperties(this, qingjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 请假状态的值
			*/
			public String getQingjiaValue() {
				return qingjiaValue;
			}
			/**
			* 设置： 请假状态的值
			*/
			public void setQingjiaValue(String qingjiaValue) {
				this.qingjiaValue = qingjiaValue;
			}




				//级联表的get和set yonghu
					/**
					* 获取： 账户
					*/
					public String getUsername() {
						return username;
					}
					/**
					* 设置： 账户
					*/
					public void setUsername(String username) {
						this.username = username;
					}
					/**
					* 获取： 密码
					*/
					public String getPassword() {
						return password;
					}
					/**
					* 设置： 密码
					*/
					public void setPassword(String password) {
						this.password = password;
					}
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
					* 获取： 部门
					*/
					public Integer getBumenTypes() {
						return bumenTypes;
					}
					/**
					* 设置： 部门
					*/
					public void setBumenTypes(Integer bumenTypes) {
						this.bumenTypes = bumenTypes;
					}


						/**
						* 获取： 部门的值
						*/
						public String getBumenValue() {
							return bumenValue;
						}
						/**
						* 设置： 部门的值
						*/
						public void setBumenValue(String bumenValue) {
							this.bumenValue = bumenValue;
						}
					/**
					* 获取： 职位
					*/
					public Integer getZhiweiTypes() {
						return zhiweiTypes;
					}
					/**
					* 设置： 职位
					*/
					public void setZhiweiTypes(Integer zhiweiTypes) {
						this.zhiweiTypes = zhiweiTypes;
					}


						/**
						* 获取： 职位的值
						*/
						public String getZhiweiValue() {
							return zhiweiValue;
						}
						/**
						* 设置： 职位的值
						*/
						public void setZhiweiValue(String zhiweiValue) {
							this.zhiweiValue = zhiweiValue;
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
					* 获取： 民族
					*/
					public String getNation() {
						return nation;
					}
					/**
					* 设置： 民族
					*/
					public void setNation(String nation) {
						this.nation = nation;
					}
					/**
					* 获取： 政治面貌
					*/
					public Integer getPoliticsTypes() {
						return politicsTypes;
					}
					/**
					* 设置： 政治面貌
					*/
					public void setPoliticsTypes(Integer politicsTypes) {
						this.politicsTypes = politicsTypes;
					}


						/**
						* 获取： 政治面貌的值
						*/
						public String getPoliticsValue() {
							return politicsValue;
						}
						/**
						* 设置： 政治面貌的值
						*/
						public void setPoliticsValue(String politicsValue) {
							this.politicsValue = politicsValue;
						}
					/**
					* 获取： 居住地
					*/
					public String getResidence() {
						return residence;
					}
					/**
					* 设置： 居住地
					*/
					public void setResidence(String residence) {
						this.residence = residence;
					}
					/**
					* 获取： 籍贯(身份证上地址)
					*/
					public String getBirthplace() {
						return birthplace;
					}
					/**
					* 设置： 籍贯(身份证上地址)
					*/
					public void setBirthplace(String birthplace) {
						this.birthplace = birthplace;
					}
					/**
					* 获取： 婚姻状况
					*/
					public Integer getMarriageTypes() {
						return marriageTypes;
					}
					/**
					* 设置： 婚姻状况
					*/
					public void setMarriageTypes(Integer marriageTypes) {
						this.marriageTypes = marriageTypes;
					}


						/**
						* 获取： 婚姻状况的值
						*/
						public String getMarriageValue() {
							return marriageValue;
						}
						/**
						* 设置： 婚姻状况的值
						*/
						public void setMarriageValue(String marriageValue) {
							this.marriageValue = marriageValue;
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
					/**
					* 获取： 审核
					*/
					public Integer getZhuangtaiTypes() {
						return zhuangtaiTypes;
					}
					/**
					* 设置： 审核
					*/
					public void setZhuangtaiTypes(Integer zhuangtaiTypes) {
						this.zhuangtaiTypes = zhuangtaiTypes;
					}


						/**
						* 获取： 审核的值
						*/
						public String getZhuangtaiValue() {
							return zhuangtaiValue;
						}
						/**
						* 设置： 审核的值
						*/
						public void setZhuangtaiValue(String zhuangtaiValue) {
							this.zhuangtaiValue = zhuangtaiValue;
						}














}
