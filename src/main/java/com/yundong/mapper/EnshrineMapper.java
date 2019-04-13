package com.yundong.mapper;

import com.yundong.entity.Enshrine;
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
public interface EnshrineMapper extends BaseMapper<Enshrine> {

    void addenshrine(Enshrine enshrine);

    List<Enshrine> selectenshrine(Integer userid);
}