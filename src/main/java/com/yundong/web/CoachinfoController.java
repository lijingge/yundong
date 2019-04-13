package com.yundong.web;

import com.yundong.common.token.Token;
import com.yundong.common.vo.Result;
import com.yundong.entity.Coachinfo;
import com.yundong.service.CoachinfoService;
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
@RestController
@Api(value = "员工信息详情",tags = "员工操作")
@RequestMapping("/api/v1")
public class CoachinfoController {
	@Autowired
    private CoachinfoService service;
	@PostMapping("addcoachinfo")
    @ApiOperation(value = "用户添加",notes = "用户添加")
	public Result addcoachinfo(String token, Coachinfo coachinfo){
	    return service.addcoachinfo(token,coachinfo);
    }
    @GetMapping("addcoachinfo")
    @ApiOperation(value = "查看员工信息",notes = "查看员工信息")
    public Result findByuid(String token){
        return service.findByuid(token);
    }
}
