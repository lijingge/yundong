package com.yundong.service.impl;

import com.alibaba.fastjson.JSON;
import com.yundong.common.constant.Constant;
import com.yundong.common.token.Token;
import com.yundong.common.utils.EncrypUtil;
import com.yundong.common.vo.Result;
import com.yundong.common.vo.ResultUtil;
import com.yundong.entity.Enshrine;
import com.yundong.entity.Userinfo;
import com.yundong.mapper.EnshrineMapper;
import com.yundong.mapper.UserinfoMapper;
import com.yundong.service.EnshrineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
@Service
public class EnshrineServiceImpl extends ServiceImpl<EnshrineMapper, Enshrine> implements EnshrineService {

    @Autowired
    private EnshrineMapper enshrinedao;

    @Autowired
    private UserinfoMapper userinfodao;
    @Override
    public Result addenshrine(String token,Integer coachid) {
        Token token1 = JSON.parseObject(EncrypUtil.decAesStr(Constant.TOKENKEY,token),Token.class);
        Userinfo userinfo = userinfodao.selectByUid(token1.getId());
        Enshrine enshrine = new Enshrine();
        enshrine.setUserid(userinfo.getId());
        enshrine.setCoachid(coachid);
        if (enshrine != null){
            enshrinedao.addenshrine(enshrine);
            return ResultUtil.setOK("收藏成功",null);
        }
        return ResultUtil.setERROR("收藏失败");
    }

    @Override
    public Result selectenshrine(String token) {
        Token token1 = JSON.parseObject(EncrypUtil.decAesStr(Constant.TOKENKEY,token),Token.class);
        Userinfo userinfo = userinfodao.selectByUid(token1.getId());
        if (userinfo.getId() != null){
            List<Enshrine> list = enshrinedao.selectenshrine(userinfo.getId());
            return ResultUtil.setOK("查询成功",list);
        }
        return ResultUtil.setERROR("查询失败");
    }
}
