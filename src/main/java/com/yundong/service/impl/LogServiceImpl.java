package com.yundong.service.impl;

import com.yundong.entity.Log;
import com.yundong.mapper.LogMapper;
import com.yundong.service.LogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yundong
 * @since 2019-03-20
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {
	
}
