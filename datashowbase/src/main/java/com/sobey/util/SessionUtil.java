package com.sobey.util;

import javax.servlet.http.HttpServletRequest;

/**
 * ession基本操作
 * Created by TS on 2017/7/8.
 */
@SuppressWarnings("unchecked")
public class SessionUtil {
    /**
     * 添加session
     * @param request
     * @param name
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T  session(HttpServletRequest request , String name , Class<T> t){
        Object obj =  request.getSession().getAttribute(name);
        return obj instanceof Class ? t.cast(obj) : (T) obj;
    }

    /**
     * 获取session
     * @param request
     * @param name
     * @param o
     */
    public static void insertSession(HttpServletRequest request , String name , Object o){
        request.getSession().setAttribute(name,o);
    }

    /**
     * 移除session
     * @param request
     * @param name
     */
    public static void removeSession(HttpServletRequest request , String name){
        request.getSession().removeAttribute(name);
    }
}
