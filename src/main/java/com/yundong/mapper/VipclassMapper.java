package com.yundong.mapper;

import com.yundong.entity.Vipclass;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
public interface VipclassMapper extends BaseMapper<Vipclass> {

    void addvipclass(Vipclass vipclass);

    void updatevipclass(Vipclass vipclass);

    List<Vipclass> findvipclass();
}