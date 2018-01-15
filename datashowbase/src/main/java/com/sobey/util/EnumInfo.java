package com.sobey.util;

/**
 * 枚举定=定义返回信息
 * Created by TS on 2017/7/9.
 */
public enum EnumInfo {

    EXCEPTION_CODE_MSG("02" , "未知异常"),

    YHM_ERROR_CODE("03" , "用户名不能为空"),

    PWD_ERROR_CODE("04" , "密码不能为空"),

    LOGIN_ERROR_CODE("05" , "用户名或密码不正确"),

    YZM_NULL_ERROR_CODE("06" , "验证码不能空"),

    YZM_ERROR_CODE("07" , "验证码错误"),

    FILE_ERROR_CODE("08" , "文件路径不存在"),

    EXCEPTION_HEADER_MSG("09" , "http 请求Header 参数异常"),

    ERROR_CODE("10" , "获取数据失败"),

    HXY_LOGIN_ERROR("11" , "华西云登陆失败"),

    HIVE_LOGIN_ERROR("12" , "hive登陆失败"),

    CODE_OUT_TOME("13" , "验证码过期"),

    PGC_UPLOAD_CODE("14" , "PGC上传失败"),

    RESULT_ERROR("15" , "后台返回数据为空"),

    ;
    private String code;

    private String msg;

    EnumInfo(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
