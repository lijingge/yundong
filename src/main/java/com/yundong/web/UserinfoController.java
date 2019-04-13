package com.yundong.web;

import com.yundong.common.vo.Result;
import com.yundong.common.vo.ResultUtil;
import com.yundong.entity.Userinfo;
import com.yundong.service.UserinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yundong
 * @since 2019-03-21
 */
@RestController
@Api(value = "用户信息操作",tags = "用户信息操作")
@RequestMapping("/api/v1")
public class UserinfoController {
	@Autowired
    private UserinfoService service;


    public static final String domain="http://localhost:9761/";
    //文件上传-图片
    @ApiOperation(value = "实现图片上传")
    @PostMapping("resource/imagesupload.do")
    public Result saveImg(MultipartFile multipartFile, HttpServletRequest request) {
        String msg = "请选择上传图片";
        if (!multipartFile.isEmpty()) {
            //文件保存
            //创建存储文件的根路径
            File dec = new File(new File(request.getServletContext().getRealPath("/")), "scresource/images");
            if (!dec.exists()) {
                dec.mkdirs();
            }
            //重命名文件名称
            String fn = multipartFile.getOriginalFilename();
            //保证原始长度小于50
            if (fn.length() > 50) {
                fn = fn.substring(fn.length() - 50);
            }
            //防止重复 加上唯一标记
            fn = System.currentTimeMillis() + "_" + UUID.randomUUID().toString().replace("-", "") + "_" + fn;

            try {
                File file = new File(dec, fn);
                multipartFile.transferTo(file);
                msg = domain + "scresource/images/" + fn;
                System.out.println(file.getAbsolutePath());
                return ResultUtil.setOK("上传成功",msg);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return ResultUtil.setdataERROR("上传失败",msg);
    }
    @ApiOperation(value = "用户信息修改",notes = "用户信息修改")
    @PostMapping("updateuserinfo")
    public Result updateuserinfo(String token, Userinfo userinfo){
        return service.updateuserinfo(token,userinfo);
    }
    @ApiOperation(value = "查看用户信息",notes = "查看用户信息")
    @GetMapping("finduserinfo")
    public Result finduserinfo(String token){
        return service.finduserinfo(token);
    }

}
