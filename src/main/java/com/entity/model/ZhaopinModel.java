package com.entity.model;

import com.entity.ZhaopinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 招聘信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-01
 */
public class ZhaopinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
     * 照片
     */
    private String myPhoto;


    /**
     * 学历
     */
    private Integer educationTypes;


    /**
     * 毕业学校
     */
    private String school;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：姓名
	 */
    public String getName() {
        return name;
    }


    /**
	 * 设置：姓名
	 */
    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 获取：手机号
	 */
    public String getPhone() {
        return phone;
    }


    /**
	 * 设置：手机号
	 */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
	 * 获取：身份证号
	 */
    public String getIdNumber() {
        return idNumber;
    }


    /**
	 * 设置：身份证号
	 */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：照片
	 */
    public String getMyPhoto() {
        return myPhoto;
    }


    /**
	 * 设置：照片
	 */
    public void setMyPhoto(String myPhoto) {
        this.myPhoto = myPhoto;
    }
    /**
	 * 获取：学历
	 */
    public Integer getEducationTypes() {
        return educationTypes;
    }


    /**
	 * 设置：学历
	 */
    public void setEducationTypes(Integer educationTypes) {
        this.educationTypes = educationTypes;
    }
    /**
	 * 获取：毕业学校
	 */
    public String getSchool() {
        return school;
    }


    /**
	 * 设置：毕业学校
	 */
    public void setSchool(String school) {
        this.school = school;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
