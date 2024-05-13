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
 * 面试
 *
 * @author 
 * @email
 * @date 2021-03-02
 */
@TableName("mianshi")
public class MianshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MianshiEntity() {

	}

	public MianshiEntity(T t) {
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
     * 招聘id
     */
    @TableField(value = "zhaopin_id")

    private Integer zhaopinId;


    /**
     * 面试时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "mianshi_time",fill = FieldFill.UPDATE)

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

    private String mianshiContent;


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
    public String getMianshiContent() {
        return mianshiContent;
    }


    /**
	 * 获取：面试评价
	 */

    public void setMianshiContent(String mianshiContent) {
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

    @Override
    public String toString() {
        return "Mianshi{" +
            "id=" + id +
            ", zhaopinId=" + zhaopinId +
            ", mianshiTime=" + mianshiTime +
            ", mianshiTypes=" + mianshiTypes +
            ", mianshiContent=" + mianshiContent +
            ", createTime=" + createTime +
        "}";
    }
}
