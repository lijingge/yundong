package com.yundong.mapper;

import com.yundong.entity.Vip;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
public interface VipMapper extends BaseMapper<Vip> {

    void addvip(Vip vip);

    void updatevip(Vip vip);

    Vip findvip(Integer userid);
}