package com.yundong.service.impl;

import com.yundong.entity.User;
import com.yundong.mapper.UserMapper;
import com.yundong.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	
}
