package com.yundong.service.impl;

import com.alibaba.fastjson.JSON;
import com.yundong.common.constant.Constant;
import com.yundong.common.massage.Message;
import com.yundong.common.token.Token;
import com.yundong.common.utils.EncrypUtil;
import com.yundong.common.utils.JedisUtil;
import com.yundong.common.utils.TokenUtil;
import com.yundong.common.vo.Result;
import com.yundong.common.vo.ResultUtil;
import com.yundong.entity.Log;
import com.yundong.entity.User;
import com.yundong.mapper.LogMapper;
import com.yundong.mapper.UserMapper;
import com.yundong.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    private UserMapper dao;

    @Autowired
    private JedisUtil jedisUtil;

    @Autowired
    private LogMapper logdao;

    @Override
    public Result adduser(String phone, String password,String code,String ip) {
        if (phone != null) {
            String oldcode = jedisUtil.getStr(phone);
            System.out.println(oldcode);
            if (code.equals(oldcode) ){
                if ( dao.selectPhone(phone) == null){
                    User user = new User();
                    user.setPhone(phone);
                    user.setPasswoad(EncrypUtil.encAesStr(Constant.REGISTERKEY, password));
                    dao.insert(user);
                }else {
                    return ResultUtil.setOtherERROR("用户已被注册");
                }
            }else {
                return ResultUtil.setOtherERROR("验证码不一致");
            }
        }
        return ResultUtil.setOtherERROR("手机号不能为空");
    }

    @Override
    public Result loginuser(String phone, String password) {
        if (phone != null){
            User user = dao.selectPhone(phone);
            if (user != null){
                String password1 = EncrypUtil.decAesStr(Constant.REGISTERKEY, user.getPasswoad());
                if (password1.equals(password)){
                    String token = TokenUtil.createToken(JSON.toJSONString(user), user.getId());
                    jedisUtil.addHash(Constant.TOKENKEY, token, token);
                    Log log = new Log();
                    log.setUserid(user.getId());
                    log.setDetails("用户登录");
                    logdao.addlogs(log);
                    return ResultUtil.setOK("登录", token, user);
                }else {
                    return ResultUtil.setERROR("用户不存在");
                }
            }
        }
        return ResultUtil.setERROR("用户名或密码不正确");
    }

    @Override
    public Result updatepass(String token, String password) {
        if (password != null){
            Token token1 = JSON.parseObject(EncrypUtil.decAesStr(Constant.TOKENKEY,token),Token.class);
            int id = token1.getId();
            User user = new User();
            user.setId(id);
            String password1 = EncrypUtil.decAesStr(Constant.REGISTERKEY, password);
            user.setPasswoad(password1);
            dao.updateById(user);
            Log log = new Log();
            log.setUserid(token1.getId());
            log.setDetails("用户修改密码");
            logdao.addlogs(log);
            return ResultUtil.setOK("密码修改成功", null);
        }
        return null;
    }

    @Override
    public Result sendMesage(String phone, String ip) throws Exception {
        String handleNumber = jedisUtil.getStr(ip);

        //用户号第一次输入手机号获取验证码
        if (Objects.isNull(handleNumber)) {
            int code = new Random().nextInt(999999);
            System.out.println(code);
            boolean result = Message.sendCode(phone, String.valueOf(code));
            if (result) {
                jedisUtil.addStr(phone, code + "", TimeUnit.MINUTES, 5);

            }

            jedisUtil.addStr(ip, 1 + "", TimeUnit.MINUTES, 3);
            return ResultUtil.setOK("验证码发送", null);
        }

        if (Integer.valueOf(handleNumber) > Constant.CODESENDNUMBER) {
            return ResultUtil.setOtherERROR("操作频繁");
        }

        //用戶不是第一次也不是規定時間超過3次
        if (Integer.valueOf(handleNumber) <= Constant.CODESENDNUMBER) {
            Integer value = Integer.valueOf(handleNumber);
            value++;
            int code = new Random().nextInt(999999);
            boolean result = Message.sendCode(phone, String.valueOf(code));
            if (result) {
                jedisUtil.addStr(phone, code + "", TimeUnit.MINUTES, 5);
            }
            jedisUtil.addStr(ip, value + "", TimeUnit.MINUTES, 3);
            return ResultUtil.setOK("验证码发送", null);
        }

        return ResultUtil.setERROR("验证");
    }
}
