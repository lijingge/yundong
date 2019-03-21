package com.yundong.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("enshrine")
public class Enshrine extends Model<Enshrine> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private Integer userid;
	private Integer coachid;


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

	public Integer getCoachid() {
		return coachid;
	}

	public void setCoachid(Integer coachid) {
		this.coachid = coachid;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
