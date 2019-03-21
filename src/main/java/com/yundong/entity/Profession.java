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
@TableName("profession")
public class Profession extends Model<Profession> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private Integer coachid;
	private Integer prid;


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

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
