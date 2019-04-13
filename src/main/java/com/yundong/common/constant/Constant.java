package com.yundong.common.constant;

/**
 * @author gfc
 * 2018年11月28日 下午 5:35
 */
public class Constant {
    public static final int OK = 1000;
    public static final int ERROR = 1001;
    public static final int PARAM_ERROR = 1002;
    public static final int REQUEST_MEETHOD_ERROR = 1003;
    public static final int NO_LOGIN = 1004;

    public static final String STORYPRAISEKEY = "story_praise";
    public static final String STORYCOLLECTKEY = "story_collection";
    public static final String COUPONVALUE = "coupon";

    public static final int CODESENDNUMBER = 3;

    public static final int CODETOKENNUMBER = 6666;
    public static final String CODETOKENKEY = "zwelBYLShnqvAXqgu7EuIg==";

    public static final String REGISTERKEY = "sODsz1xF0AEDolEFhxatCA==";

    public static final String TOKENKEY = "Lm6Ono9B/kjP8Sw58VtHcw==";

    public static final String USERINFO = "userinfo";
    //Redis存储Token的集合名称
    public static final String TOKENMAP="usertokens";
    public static final String PHONETOKEN="phonetoken";
    //Redis存储签到的连续天数
    public static final String SIGNINMAP="usersignindays";

    public static final Integer PAGENUM=1;
    public static final Integer PAGESIZE=10;
    //Cookie的常用键
    public static final String COOKIETOKEN="scyoken";
    //存储图片
    public static final String BULCKNAME="ossjava";
}
