package com.yundong.service.impl;

import com.alibaba.fastjson.JSON;
import com.yundong.common.constant.Constant;
import com.yundong.common.token.Token;
import com.yundong.common.utils.EncrypUtil;
import com.yundong.common.utils.JedisUtil;
import com.yundong.common.utils.TokenUtil;
import com.yundong.common.vo.Result;
import com.yundong.common.vo.ResultUtil;
import com.yundong.entity.Sign;
import com.yundong.entity.Userinfo;
import com.yundong.mapper.SignMapper;
import com.yundong.mapper.UserinfoMapper;
import com.yundong.service.SignService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
@Service
public class SignServiceImpl extends ServiceImpl<SignMapper, Sign> implements SignService {
    @Autowired
    private SignMapper dao;
    @Autowired
    private UserinfoMapper userinfodao;
    @Autowired
    private JedisUtil jedisUtil;
    @Override
    public Result addsign(String token) {
        Token token1 = JSON.parseObject(EncrypUtil.decAesStr(Constant.TOKENKEY,token),Token.class);
        Userinfo userinfo = userinfodao.selectByUid(token1.getId());
        if (userinfo == null){
            return ResultUtil.setOtherERROR("请完善用户资料");
        }
        Calendar now=Calendar.getInstance();
        Calendar lastTime=Calendar.getInstance();
        Random random=new Random();
        int integral = random.nextInt(5)+1;
        Sign sign =dao.selectbyuid(userinfo.getId());
        Sign sign1 = new Sign();
        if (sign == null){
            sign1.setUserid(userinfo.getId());
            sign1.setSignnum(1);
            sign1.setContinuous(1);
            sign1.setIntegral(20);
            dao.insert(sign1);
            return ResultUtil.setOK("签到成功",null);
        }else {
            lastTime.setTime(sign.getSigntime());
            if (now.get(Calendar.DAY_OF_YEAR )- lastTime.get(Calendar.DAY_OF_YEAR) > 1 || sign.getContinuous() == 7){
                sign1.setUserid(userinfo.getId());
                sign1.setSignnum(sign.getSignnum() + 1);
                sign1.setContinuous(1);
                sign1.setIntegral(sign.getIntegral() + integral);
                dao.insert(sign1);
                return ResultUtil.setOK("签到成功",null);
            }else if(now.get(Calendar.DAY_OF_YEAR )- lastTime.get(Calendar.DAY_OF_YEAR) == 0){
                return ResultUtil.setOtherERROR("用户重复签到");
            }else {
                sign1.setUserid(userinfo.getId());
                sign1.setSignnum(sign.getSignnum() + 1);
                sign1.setContinuous(sign.getContinuous() + 1);
                sign1.setIntegral(sign.getIntegral() + (integral * 2));
                dao.insert(sign1);
                return ResultUtil.setOK("签到成功",null);
            }
        }
    }

    @Override
    public Result findsign(String token) {
        Token token1 = JSON.parseObject(EncrypUtil.decAesStr(Constant.TOKENKEY,token),Token.class);
        System.out.println(token1.getId());
        Userinfo userinfo = userinfodao.selectByUid(token1.getId());
        if (userinfo == null){
            return ResultUtil.setOtherERROR("请完善用户资料");
        }
        Calendar now=Calendar.getInstance();
        Calendar lastTime=Calendar.getInstance();
        if (userinfo != null){
            if (now.get(Calendar.DAY_OF_YEAR )- lastTime.get(Calendar.DAY_OF_YEAR) == 0){
                return ResultUtil.setOK("用户已签到",userinfo);
            }else {
                return ResultUtil.setdataERROR("用户未签到",userinfo);
            }
        }else {
            return ResultUtil.setOtherERROR("用户还未签到");
        }
    }
}
