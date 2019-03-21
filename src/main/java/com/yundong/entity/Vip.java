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
 * @since 2019-03-20
 */
@TableName("vip")
public class Vip extends Model<Vip> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	private Integer userid;
	private Integer classid;
	private Date viptime;
	private Integer timelenth;
	private Integer hour;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
