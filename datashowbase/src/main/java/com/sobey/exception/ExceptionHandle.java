package com.sobey.exception;

import com.sobey.util.EnumInfo;
import com.sobey.util.ReturnInfo;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 异常最终处理类
 * Created by TS on 2017/7/9.
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = Logger.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String , Object> handle(Exception e){
        if(e instanceof FinalException){
            FinalException ex = (FinalException) e;
            ex.printStackTrace();
            logger.error("异常信息：["+ ex.getMessage() +"]");
            return ReturnInfo.error(ex.getCode() , ex.getMessage());
        }else {
            EnumInfo en = EnumInfo.EXCEPTION_CODE_MSG;
            e.printStackTrace();
            en.setMsg("异常信息:["+ e.getMessage() +"]");
            logger.error("异常信息:["+ e.getMessage() +"]");
            return ReturnInfo.error(en);
        }
    }


}
