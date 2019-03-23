package com.yundong.web;

import com.yundong.common.vo.Result;
import com.yundong.service.SignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api(value = "签到",tags = "签到")
@RequestMapping("/api/v1")
@RestController
public class SignController {
    @Autowired
    private SignService service;
    @ApiOperation(value = "签到",notes = "签到")
    @PostMapping("addsign")
    public Result addsign(String token){
        return service.addsign(token);
    }
    @ApiOperation(value = "查询签到情况",notes = "查询签到情况")
    @GetMapping("findsign")
    public Result findsign(String token){
        return service.findsign(token);
    }
}
