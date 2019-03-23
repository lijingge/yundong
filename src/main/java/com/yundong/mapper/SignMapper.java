package com.yundong.mapper;

import com.yundong.entity.Sign;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
public interface SignMapper extends BaseMapper<Sign> {

    Sign selectbyuid(int id);
}