package com.yundong.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yundong.common.constant.Constant;
import com.yundong.common.token.Token;
import com.yundong.common.utils.EncrypUtil;
import com.yundong.common.utils.JedisUtil;
import com.yundong.common.vo.Result;
import com.yundong.common.vo.ResultUtil;
import com.yundong.entity.Coachinfo;
import com.yundong.entity.Userinfo;
import com.yundong.mapper.CoachinfoMapper;
import com.yundong.service.CoachinfoService;
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
public class CoachinfoServiceImpl extends ServiceImpl<CoachinfoMapper, Coachinfo> implements CoachinfoService {

    @Autowired
    private CoachinfoMapper coachinfodao;
    @Autowired
    private JedisUtil jedisUtil;
    @Override
    public Result addcoachinfo(String token, Coachinfo coachinfo) {
        Token token1 = JSON.parseObject(EncrypUtil.decAesStr(Constant.TOKENKEY,token),Token.class);
        Coachinfo coachinfo1 = coachinfodao.selectByUid(token1.getId());
        if (coachinfo1 == null){
            int i = coachinfodao.adduserinfo(coachinfo);
            if (i > 0){
                return ResultUtil.setOK("信息完善成功",null);
            }

        }else {
            coachinfo.setUid(token1.getId());
            coachinfodao.updateuserinfo(coachinfo);
            return ResultUtil.setOK("信息修改成功",null);
        }
        return ResultUtil.setERROR("修改失败");
    }

    @Override
    public Result findByuid(String token) {
        Token token1 = JSON.parseObject(EncrypUtil.decAesStr(Constant.TOKENKEY,token),Token.class);
        Coachinfo coachinfo1 = coachinfodao.selectByUid(token1.getId());
        if (coachinfo1 != null){
            return ResultUtil.setOK("查询成功",coachinfo1);
        }
        return ResultUtil.setERROR("用户查询失败，查看是否已完善信息");
    }
}
