package com.yundong.common.vo;


import com.yundong.common.constant.Constant;

/**
 * @author gfc
 * 2018年11月28日 下午 5:41
 */
public class ResultUtil {
    public static Result setOK(String msg, Object data) {
        Result result = new Result();
        result.setCode(Constant.OK);
        result.setMsg(msg + "成功");
        result.setData(data);
        return result;
    }
    public static Result setOtherOK(String msg, Object data) {
        Result result = new Result();
        result.setCode(Constant.OK);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }


    public static Result setOK(String msg, String other, Object data) {
        Result result = new Result();
        result.setCode(Constant.OK);
        result.setMsg(msg + "成功");
        result.setOther(other);
        result.setData(data);
        return result;
    }

    public static Result setERROR(String msg) {
        Result result = new Result();
        result.setCode(Constant.ERROR);
        result.setMsg(msg + "失败");
        return result;
    }
    public static Result setdataERROR(String msg,Object data) {
        Result result = new Result();
        result.setCode(Constant.ERROR);
        result.setMsg(msg + "已签到");
        result.setData(data);
        return result;
    }

    public static Result setOtherERROR(String msg) {
        Result result = new Result();
        result.setCode(Constant.ERROR);
        result.setMsg(msg);
        return result;
    }
}
