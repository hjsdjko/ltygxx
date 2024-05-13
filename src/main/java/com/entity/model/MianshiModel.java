package com.entity.model;

import com.entity.MianshiEntity;

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
public class MianshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 招聘id
     */
    private Integer zhaopinId;


    /**
     * 面试时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date mianshiTime;


    /**
     * 面试结果
     */
    private Integer mianshiTypes;


    /**
     * 面试评价
     */
    private Integer mianshiContent;


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
	 * 获取：招聘id
	 */
    public Integer getZhaopinId() {
        return zhaopinId;
    }


    /**
	 * 设置：招聘id
	 */
    public void setZhaopinId(Integer zhaopinId) {
        this.zhaopinId = zhaopinId;
    }
    /**
	 * 获取：面试时间
	 */
    public Date getMianshiTime() {
        return mianshiTime;
    }


    /**
	 * 设置：面试时间
	 */
    public void setMianshiTime(Date mianshiTime) {
        this.mianshiTime = mianshiTime;
    }
    /**
	 * 获取：面试结果
	 */
    public Integer getMianshiTypes() {
        return mianshiTypes;
    }


    /**
	 * 设置：面试结果
	 */
    public void setMianshiTypes(Integer mianshiTypes) {
        this.mianshiTypes = mianshiTypes;
    }
    /**
	 * 获取：面试评价
	 */
    public Integer getMianshiContent() {
        return mianshiContent;
    }


    /**
	 * 设置：面试评价
	 */
    public void setMianshiContent(Integer mianshiContent) {
        this.mianshiContent = mianshiContent;
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
