package com.sobey.controller;

import com.alibaba.fastjson.JSONObject;
import com.sobey.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.net.URLEncoder;

@RestController
public class CrossController {

    public static Logger LOGGER = LoggerFactory.getLogger(CrossController.class);

    @PostMapping(value = "/cross/domain")
    public Object getPostData(@RequestBody String body , @RequestParam String url) throws Exception{
        String url_ = URLDecoder.decode(url , "utf-8");
        String result = HttpClientUtil.postHeader(body , url_ , null);
        return result;
    }

    @GetMapping(value = "/cross/domain")
    public Object getData(@RequestParam String url , String starttime , String endtime) throws Exception{
        String url_ = URLDecoder.decode(url , "utf-8");
        if(!StringUtils.isEmpty(starttime) && !StringUtils.isEmpty(endtime)){
            url_ = url_ + "&begindate=" + URLEncoder.encode(starttime,"utf-8") + "&enddate=" + URLEncoder.encode(endtime,"utf-8");
        }
        String result = HttpClientUtil.getHeader(url_ , null);
        return result;
    }

    @PostMapping(value = "/cross/domain/zj")
    public Object getData(@RequestBody String body) throws Exception{
        JSONObject object = JSONObject.parseObject(body);
        String url = object.getString("url");
        LOGGER.info("浙江转发接口请求参数：" + body);
        object.remove("url");
        String result = HttpClientUtil.postHeader(object.toString() , url , null);
        LOGGER.info("浙江转发接口后台返回参数：" + result);
        return JSONObject.parseObject(result);
    }

}
