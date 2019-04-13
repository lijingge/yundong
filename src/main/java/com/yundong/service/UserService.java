package com.yundong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yundong.common.vo.Result;
import com.yundong.entity.User;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
public interface UserService extends IService<User> {

    Result adduser(String phone, String password, String code, String ip);

    Result loginuser(String phone, String password);

    Result updatepass(String token, String password);

    Result sendMesage(String phone, String ip) throws Exception;

    Result exit(String token);

    Result updatetyoe(Integer id, Integer usertype);

    Result updateflag(Integer id);
}
