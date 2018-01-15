package com.sobey.util;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理跨域问题
 * Created by TS on 2017/7/11.
 */
public class CorsFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String method = ((HttpServletRequest) request).getMethod();
        HttpServletResponse res = (HttpServletResponse) response;

        String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        res.addHeader("host", host);
        res.addHeader("Access-Control-Expose-Headers","Roleplay-Error-Code");
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        res.addHeader("Access-Control-Allow-Credentials", "true");
        res.addHeader("Access-Control-Allow-Headers",
                "Origin, Content-Type, Accept, Authorization, x-requested-with, cache-control, Access-Control-Allow-Origin, Access-Control-Allow-Credentials, uuid");

        if (method.equals("OPTIONS")) {
            res.setStatus(HttpServletResponse.SC_OK);
        }else {
            filterChain.doFilter(request, response);
        }

    }
    @Override
    public void destroy() {

    }
}
