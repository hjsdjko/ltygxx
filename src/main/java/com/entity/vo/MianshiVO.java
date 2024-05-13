package com.entity.vo;

import com.entity.MianshiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 招聘信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-01
 */
@TableName("mianshi")
public class MianshiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 招聘id
     */

    @TableField(value = "zhaopin_id")
    private Integer zhaopinId;


    /**
     * 面试时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "mianshi_time")
    private Date mianshiTime;


    /**
     * 面试结果
     */

    @TableField(value = "mianshi_types")
    private Integer mianshiTypes;


    /**
     * 面试评价
     */

    @TableField(value = "mianshi_content")
    private Integer mianshiContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：招聘id
	 */
    public Integer getZhaopinId() {
        return zhaopinId;
    }


    /**
	 * 获取：招聘id
	 */

    public void setZhaopinId(Integer zhaopinId) {
        this.zhaopinId = zhaopinId;
    }
    /**
	 * 设置：面试时间
	 */
    public Date getMianshiTime() {
        return mianshiTime;
    }


    /**
	 * 获取：面试时间
	 */

    public void setMianshiTime(Date mianshiTime) {
        this.mianshiTime = mianshiTime;
    }
    /**
	 * 设置：面试结果
	 */
    public Integer getMianshiTypes() {
        return mianshiTypes;
    }


    /**
	 * 获取：面试结果
	 */

    public void setMianshiTypes(Integer mianshiTypes) {
        this.mianshiTypes = mianshiTypes;
    }
    /**
	 * 设置：面试评价
	 */
    public Integer getMianshiContent() {
        return mianshiContent;
    }


    /**
	 * 获取：面试评价
	 */

    public void setMianshiContent(Integer mianshiContent) {
        this.mianshiContent = mianshiContent;
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

}
