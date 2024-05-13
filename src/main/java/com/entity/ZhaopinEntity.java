package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 招聘信息
 *
 * @author 
 * @email
 * @date 2021-03-02
 */
@TableName("zhaopin")
public class ZhaopinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhaopinEntity() {

	}

	public ZhaopinEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 姓名
     */
    @TableField(value = "name")

    private String name;


    /**
     * 手机号
     */
    @TableField(value = "phone")

    private String phone;


    /**
     * 身份证号
     */
    @TableField(value = "id_number")

    private String idNumber;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 照片
     */
    @TableField(value = "my_photo")

    private String myPhoto;


    /**
     * 学历
     */
    @TableField(value = "education_types")

    private Integer educationTypes;


    /**
     * 毕业学校
     */
    @TableField(value = "school")

    private String school;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：姓名
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：姓名
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：手机号
	 */
    public String getPhone() {
        return phone;
    }


    /**
	 * 获取：手机号
	 */

    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
	 * 设置：身份证号
	 */
    public String getIdNumber() {
        return idNumber;
    }


    /**
	 * 获取：身份证号
	 */

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：照片
	 */
    public String getMyPhoto() {
        return myPhoto;
    }


    /**
	 * 获取：照片
	 */

    public void setMyPhoto(String myPhoto) {
        this.myPhoto = myPhoto;
    }
    /**
	 * 设置：学历
	 */
    public Integer getEducationTypes() {
        return educationTypes;
    }


    /**
	 * 获取：学历
	 */

    public void setEducationTypes(Integer educationTypes) {
        this.educationTypes = educationTypes;
    }
    /**
	 * 设置：毕业学校
	 */
    public String getSchool() {
        return school;
    }


    /**
	 * 获取：毕业学校
	 */

    public void setSchool(String school) {
        this.school = school;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Zhaopin{" +
            "id=" + id +
            ", name=" + name +
            ", phone=" + phone +
            ", idNumber=" + idNumber +
            ", sexTypes=" + sexTypes +
            ", myPhoto=" + myPhoto +
            ", educationTypes=" + educationTypes +
            ", school=" + school +
            ", createTime=" + createTime +
        "}";
    }
}
