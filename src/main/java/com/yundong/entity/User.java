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
@TableName("user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String phone;
	private String passwoad;
	private Integer usertype;
	private Integer falg;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPasswoad() {
		return passwoad;
	}

	public void setPasswoad(String passwoad) {
		this.passwoad = passwoad;
	}

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	public Integer getFalg() {
		return falg;
	}

	public void setFalg(Integer falg) {
		this.falg = falg;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
