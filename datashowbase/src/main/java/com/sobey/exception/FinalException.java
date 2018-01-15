package com.sobey.exception;

import com.sobey.util.EnumInfo;

/**
 * 自定义异常处理类
 * Created by TS on 2017/7/9.
 */
public class FinalException extends RuntimeException{

    /**
     * 返回码
     */
    private String code;

    public FinalException(String code , String msg){
        super(msg);
        this.code = code;
    }

    public FinalException(EnumInfo e){
        super(e.getMsg());
        this.code = e.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
