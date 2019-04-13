package com.yundong.service.impl;

import com.yundong.common.vo.Result;
import com.yundong.common.vo.ResultUtil;
import com.yundong.entity.Vipclass;
import com.yundong.mapper.VipclassMapper;
import com.yundong.service.VipclassService;
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
public class VipclassServiceImpl extends ServiceImpl<VipclassMapper, Vipclass> implements VipclassService {

    @Autowired
    private VipclassMapper vipclassdao;

    @Override
    public Result addvipclass(Vipclass vipclass) {
        if (vipclass != null){
            vipclassdao.addvipclass(vipclass);
            return ResultUtil.setOK("添加成功",null);
        }else {
            return ResultUtil.setERROR("值不能为空");
        }
    }

    @Override
    public Result updatevipclass(Vipclass vipclass) {
        if (vipclass != null){
            vipclassdao.updatevipclass(vipclass);
            return ResultUtil.setOK("修改成功",null);
        }else {
            return ResultUtil.setERROR("值不能为空");
        }
    }

    @Override
    public Result findvipclass() {
        List<Vipclass> list = vipclassdao.findvipclass();
        return ResultUtil.setOK("查询成功",list);
    }
}
