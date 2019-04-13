package com.yundong.mapper;

import com.yundong.entity.Userinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
public interface UserinfoMapper extends BaseMapper<Userinfo> {

    Userinfo selectByUid(int uid);

    int adduserinfo(Userinfo userinfo);

    void updateuserinfo(Userinfo userinfo);
}