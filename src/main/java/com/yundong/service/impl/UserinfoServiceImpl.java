package com.yundong.service.impl;

import com.alibaba.fastjson.JSON;
import com.yundong.common.constant.Constant;
import com.yundong.common.token.Token;
import com.yundong.common.utils.EncrypUtil;
import com.yundong.common.utils.JedisUtil;
import com.yundong.common.vo.Result;
import com.yundong.common.vo.ResultUtil;
import com.yundong.entity.Userinfo;
import com.yundong.mapper.UserinfoMapper;
import com.yundong.service.UserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements UserinfoService {

    @Autowired
    private UserinfoMapper userinfodao;
    @Autowired
    private JedisUtil jedisUtil;
    @Override
    public Result updateuserinfo(String token, Userinfo userinfo) {
        Token token1 = JSON.parseObject(EncrypUtil.decAesStr(Constant.TOKENKEY,token),Token.class);
        Userinfo userinfo1 = userinfodao.selectByUid(token1.getId());
        if (userinfo1 == null){
            int i = userinfodao.adduserinfo(userinfo);
            if (i > 0){
                return ResultUtil.setOK("信息完善成功",null);
            }

        }else {
            userinfo.setUid(token1.getId());
            userinfodao.updateuserinfo(userinfo);
            return ResultUtil.setOK("信息修改成功",null);
        }
        return ResultUtil.setERROR("修改失败");
    }

    @Override
    public Result finduserinfo(String token) {
        Token token1 = JSON.parseObject(EncrypUtil.decAesStr(Constant.TOKENKEY,token),Token.class);
        Userinfo userinfo1 = userinfodao.selectByUid(token1.getId());
        if (userinfo1 != null){
            return ResultUtil.setOK("查询成功",userinfo1);
        }
        return ResultUtil.setERROR("用户查询失败，查看是否已完善信息");
    }
}
