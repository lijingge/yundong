package com.yundong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yundong.common.vo.Result;
import com.yundong.entity.Enshrine;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
public interface EnshrineService extends IService<Enshrine> {

    Result addenshrine(String token,Integer coachid);

    Result selectenshrine(String token);
}
