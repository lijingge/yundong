package com.yundong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yundong.common.token.Token;
import com.yundong.common.vo.Result;
import com.yundong.entity.Coachinfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
public interface CoachinfoService extends IService<Coachinfo> {

    Result addcoachinfo(String token, Coachinfo coachinfo);

    Result findByuid(String token);
}
