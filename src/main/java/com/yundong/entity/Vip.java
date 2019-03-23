package com.yundong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("vip")
public class Vip extends Model<Vip> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private Integer userid;
	private Integer classid;
	private Date viptime;
	private Integer timelenth;
	private Integer hour;


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

	public Integer getClassid() {
		return classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public Date getViptime() {
		return viptime;
	}

	public void setViptime(Date viptime) {
		this.viptime = viptime;
	}

	public Integer getTimelenth() {
		return timelenth;
	}

	public void setTimelenth(Integer timelenth) {
		this.timelenth = timelenth;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
