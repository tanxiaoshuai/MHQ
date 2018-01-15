package com.sobey.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息返回模板
 * Created by TS on 2017/7/8.
 */
public class ReturnInfo {

    /**
     * 返回消息模板
     * @param obj 返回数据
     * @return
     */
    public static Map<String , Object> success(Object obj){
        Map<String , Object> map = new HashMap<>();
        map.put("code" , "00");
        map.put("msg" , "成功");
        map.put("data" , obj);
        return map;
    }

    public static <T> T success(Class<T> obj){
        Map<String , Object> map = new HashMap<>();
        map.put("code" , "00");
        map.put("msg" , "成功");
        map.put("data" , obj);
        return (T)map;
    }

    /**
     * 返回无内容
     * @return
     */
    public static Map<String , Object> success(){
        Map<String , Object> map = new HashMap<>();
        map.put("code" , "00");
        map.put("msg" , "成功");
        map.put("data" , "");
        return map;
    }

    /**
     * 定义返回码 返回信息
     * @param code
     * @param msg
     * @return
     */
    public static Map<String , Object> error(String code , String msg){
        Map<String , Object> map = new HashMap<>();
        map.put("code" , code);
        map.put("msg" , msg);
        map.put("data" , "");
        return map;
    }

    /**
     * 枚举定义
     * @param e
     * @return
     */
    public static Map<String , Object> error(EnumInfo e){
        Map<String , Object> map = new HashMap<>();
        map.put("code" , e.getCode());
        map.put("msg" , e.getMsg());
        map.put("data" , "");
        return map;
    }

}
