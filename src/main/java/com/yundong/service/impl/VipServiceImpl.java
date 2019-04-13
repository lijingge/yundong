package com.yundong.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yundong.common.constant.Constant;
import com.yundong.common.token.Token;
import com.yundong.common.utils.EncrypUtil;
import com.yundong.common.vo.Result;
import com.yundong.common.vo.ResultUtil;
import com.yundong.entity.Userinfo;
import com.yundong.entity.Vip;
import com.yundong.mapper.UserinfoMapper;
import com.yundong.mapper.VipMapper;
import com.yundong.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
@Service
public class VipServiceImpl extends ServiceImpl<VipMapper, Vip> implements VipService {

    @Autowired
    private VipMapper vipdao;
    @Autowired
    private UserinfoMapper userinfodao;
    @Override
    public Result addvip(String token, int classid) {
        if (token != null){
            Token token1 = JSON.parseObject(EncrypUtil.decAesStr(Constant.TOKENKEY,token),Token.class);
            Userinfo userinfo = userinfodao.selectByUid(token1.getId());
            Vip vip = new Vip();
            switch (classid){
                case 1:
                    vip.setTimelenth(365);
                    break;
                case 2:
                    vip.setTimelenth(180);
                    break;
                case 3:
                    vip.setTimelenth(90);
                    break;
                case 4:
                    vip.setTimelenth(30);
                    break;
            }
            vip.setClassid(classid);
            vip.setUserid(userinfo.getId());
            vip.setViptime(new Date());
            vipdao.addvip(vip);
            return ResultUtil.setOK("添加成功",null);
        }
       return ResultUtil.setERROR("请登录");
    }

    @Override
    public Result updatevip(Vip vip) {
        if(vip != null){
            vipdao.updatevip(vip);
            return ResultUtil.setOK("修改成功",null);
        }
        return ResultUtil.setERROR("传入内容不能为空");
    }

    @Override
    public Result findvip(String token) {
        Token token1 = JSON.parseObject(EncrypUtil.decAesStr(Constant.TOKENKEY,token),Token.class);
        Userinfo userinfo = userinfodao.selectByUid(token1.getId());
        if (userinfo.getId() != null){
            Vip vip = vipdao.findvip(userinfo.getId());
            if (vip != null){
                return ResultUtil.setOK("查询成功",vip);
            }
            return ResultUtil.setERROR("用户未开通");
        }
        return ResultUtil.setERROR("查询失败");
    }
}
