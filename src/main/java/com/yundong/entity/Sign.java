package com.yundong.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
@TableName("sign")
public class Sign extends Model<Sign> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer userid;
	private Integer signnum;
	private Integer continuous;
	private Date signtime;
	private Integer integral;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getSignnum() {
		return signnum;
	}

	public void setSignnum(Integer signnum) {
		this.signnum = signnum;
	}

	public Integer getContinuous() {
		return continuous;
	}

	public void setContinuous(Integer continuous) {
		this.continuous = continuous;
	}

	public Date getSigntime() {
		return signtime;
	}

	public void setSigntime(Date signtime) {
		this.signtime = signtime;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
