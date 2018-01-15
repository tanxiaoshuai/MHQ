package com.sobey.exception;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆拦截器
 * Created by TS on 2017/7/9.
 */
public class URLInterceptor implements HandlerInterceptor {

    private Logger logger = Logger.getLogger(URLInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String reqUrl = httpServletRequest.getRequestURL().toString().trim();
        logger.info("当前请求的地址：["+ reqUrl +"]");
        String basePath = httpServletRequest.getScheme() + "://"
                + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort();
            httpServletResponse.sendRedirect("http://www.baidu.com");
            return false;
    }

    //请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //在整个请求结束之后被调用
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
