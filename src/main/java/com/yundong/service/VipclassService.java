package com.yundong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yundong.common.vo.Result;
import com.yundong.entity.Vipclass;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
public interface VipclassService extends IService<Vipclass> {

    Result addvipclass(Vipclass vipclass);

    Result updatevipclass(Vipclass vipclass);

    Result findvipclass();
}
