package com.yundong.mapper;

import com.yundong.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
public interface UserMapper extends BaseMapper<User> {

    User selectPhone(String phone);

    void insertSelective(User user);

    void updatepass(User user);

    User selectid(Integer id);

    void updateId(User user1);

    void updatetype(User user1);
}