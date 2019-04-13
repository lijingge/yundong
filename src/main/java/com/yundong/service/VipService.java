package com.yundong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yundong.common.vo.Result;
import com.yundong.entity.Vip;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
public interface VipService extends IService<Vip> {

    Result addvip(String token, int classid);

    Result updatevip(Vip vip);

    Result findvip(String token);
}
