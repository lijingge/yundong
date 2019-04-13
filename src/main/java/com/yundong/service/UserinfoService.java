package com.yundong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yundong.common.vo.Result;
import com.yundong.entity.Userinfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
public interface UserinfoService extends IService<Userinfo> {

    Result updateuserinfo(String token, Userinfo userinfo);

    Result finduserinfo(String token);
}
