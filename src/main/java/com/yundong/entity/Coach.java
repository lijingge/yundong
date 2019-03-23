package com.yundong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
@TableName("coach")
public class Coach extends Model<Coach> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private Integer coachid;
	private Integer userid;
	private Date codete;
	private Date codtime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getCodete() {
		return codete;
	}

	public void setCodete(Date codete) {
		this.codete = codete;
	}

	public Date getCodtime() {
		return codtime;
	}

	public void setCodtime(Date codtime) {
		this.codtime = codtime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
