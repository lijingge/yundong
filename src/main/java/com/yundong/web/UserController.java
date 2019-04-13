package com.yundong.web;

import com.yundong.common.constant.Constant;
import com.yundong.common.vo.Result;
import com.yundong.common.vo.ResultUtil;
import com.yundong.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
@Api(value = "用户操作",tags = "用户操作")
@RequestMapping("/api/v1")
@RestController
public class UserController {
    @Autowired
    private UserService service;
    @ApiOperation(value = "注册",notes = "注册")
    @PostMapping("adduser")
    public Result adduser(String phone, String password, String code, String ip){
        return service.adduser(phone,password,code,ip);
    }
    @ApiOperation(value = "登录",notes = "登录")
    @PostMapping("loginuser")
    public Result loginuser(String phone,String password){

        return service.loginuser(phone,password);
    }
    @ApiOperation(value = "登录状态下修改密码",notes = "登录状态下修改密码")
    @PutMapping("updatepass")
    public Result updatepass(String token, String password){
        return service.updatepass(token,password);
    }
    @PostMapping("/message")
    public Result sendMessage(String phone, HttpServletRequest request) throws Exception {
        return service.sendMesage(phone, request.getRemoteAddr());
    }
    @ApiOperation(value = "用户注销登陆",notes = "注销登陆使用token")
    @PostMapping("/loginout")
    public Result loginOut(String token) {
        return service.exit(token);
    }
    @ApiOperation(value = "修改用户操作",notes = "修改用户操作")
    @PutMapping("/updatetyoe")
    public Result updatetyoe(Integer id,Integer usertype) {
        return service.updatetyoe(id,usertype);
    }
    @ApiOperation(value = "冻结或解冻用户",notes = "冻结或解冻用户")
    @PutMapping("/updateflag")
    public Result updateflag(Integer id) {
        return service.updateflag(id);
    }
}
