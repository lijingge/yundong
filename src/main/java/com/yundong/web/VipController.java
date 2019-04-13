package com.yundong.web;

import com.yundong.common.vo.Result;
import com.yundong.entity.Vip;
import com.yundong.service.VipService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
@Api(value = "会员卡管理",tags = "会员卡管理")
@RestController
@RequestMapping("/api/v1")
public class VipController {
    @Autowired
    private VipService service;
    @ApiOperation(value = "添加",notes = "添加")
    @PostMapping("addvip")
    public Result addvip(String token,int classid){
        return service.addvip(token,classid);
    }
    @ApiOperation(value = "修改",notes = "修改")
    @PutMapping("updatevip")
    public Result updatevip(Vip vip){
        return service.updatevip(vip);
    }

    @ApiOperation(value = "展示",notes = "展示")
    @GetMapping("findvip")
    public Result findvip(String token){
        return service.findvip(token);
    }
}
