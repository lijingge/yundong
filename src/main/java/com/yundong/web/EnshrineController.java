package com.yundong.web;

import com.yundong.common.vo.Result;
import com.yundong.entity.Enshrine;
import com.yundong.service.EnshrineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
@Api(value = "收藏操作",tags = "收藏操作")
@RequestMapping("/api/v1")
@RestController
public class EnshrineController {
    @Autowired
    private EnshrineService service;
    @ApiOperation(value = "收藏",notes = "收藏")
    @PostMapping("addenshrine")
    public Result addenshrine(String token,Integer coachid){
        return service.addenshrine(token,coachid);
    }
    @ApiOperation(value = "收藏",notes = "收藏")
    @PostMapping("selectenshrine")
    public Result selectenshrine(String token){
        return service.selectenshrine(token);
    }
}
