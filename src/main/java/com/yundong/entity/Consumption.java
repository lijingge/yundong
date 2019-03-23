package com.yundong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.math.BigDecimal;
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
@TableName("Consumption")
public class Consumption extends Model<Consumption> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private Integer userid;
	private String consumtype;
	private Integer hour;
	private BigDecimal money;
	private Integer conintegral;
	private Integer situation;


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

	public String getConsumtype() {
		return consumtype;
	}

	public void setConsumtype(String consumtype) {
		this.consumtype = consumtype;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Integer getConintegral() {
		return conintegral;
	}

	public void setConintegral(Integer conintegral) {
		this.conintegral = conintegral;
	}

	public Integer getSituation() {
		return situation;
	}

	public void setSituation(Integer situation) {
		this.situation = situation;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
