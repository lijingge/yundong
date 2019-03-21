package com.yundong.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
@TableName("salesman")
public class Salesman extends Model<Salesman> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	private Integer coachid;
	private Integer userid;
	private Date applytime;
	private Integer classid;
	private Integer saletype;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCoachid() {
		return coachid;
	}

	public void setCoachid(Integer coachid) {
		this.coachid = coachid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Date getApplytime() {
		return applytime;
	}

	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}

	public Integer getClassid() {
		return classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public Integer getSaletype() {
		return saletype;
	}

	public void setSaletype(Integer saletype) {
		this.saletype = saletype;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
