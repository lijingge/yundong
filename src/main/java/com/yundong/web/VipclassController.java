package com.yundong.web;

import com.yundong.common.vo.Result;
import com.yundong.entity.Vipclass;
import com.yundong.service.VipclassService;
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
@RestController
@Api(value = "会等级管理",tags = "会等级管理")
@RequestMapping("/api/v1")
public class VipclassController {

    @Autowired
    private VipclassService service;
    @ApiOperation(value = "添加会员等级",notes = "添加会员等级")
    @PostMapping("addvipclass")
    public Result addvipclass(Vipclass vipclass){
        return service.addvipclass(vipclass);
    }

    @ApiOperation(value = "修改会员等级",notes = "修改会员等级")
    @PutMapping("updatevipclass")
    public Result updatevipclass(Vipclass vipclass){
        return service.updatevipclass(vipclass);
    }
    @ApiOperation(value = "获取会员等级",notes = "获取会员等级")
    @GetMapping("findvipclass")
    public Result findvipclass(){
        return service.findvipclass();
    }
}
