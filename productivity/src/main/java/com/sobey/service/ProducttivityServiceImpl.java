package com.sobey.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sobey.config.BaseInfo;
import com.sobey.config.ConfigUrl;
import com.sobey.exception.FinalException;
import com.sobey.util.EnumInfo;
import com.sobey.util.HttpClientUtil;
import com.sobey.util.ReturnInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ProducttivityServiceImpl implements IproducttivityService {

    private static Logger LOGGER = LoggerFactory.getLogger(ProducttivityServiceImpl.class);

    @Autowired
    private BaseInfo info;

    @Autowired
    private ConfigUrl config;

    @Override
    public Object publish(String type) throws Exception {
        String url = config.getProduct_publish().replace("{type}" , type);
        LOGGER.info("生产力微信微博请求地址：" + url);
        String result = HttpClientUtil.getHeader(url , null);
        LOGGER.info("生产力微信微博后台返回数据：" + result);
        if(StringUtils.isEmpty(result)){
            throw new FinalException(EnumInfo.RESULT_ERROR);
        }
        JSONObject object = JSONObject.parseObject(result);
        if(object.getInteger("status") == 200){
            object = object.getJSONObject("data");
        }
        return ReturnInfo.success(object);
    }

    @Override
    public Object newest(String type) throws Exception {
        String url = config.getProduct_newest().replace("{type}" , type);
        LOGGER.info("生产力微信微博请求地址：" + url);
        String result = HttpClientUtil.getHeader(url , null);
        LOGGER.info("生产力微信微博后台返回数据：" + result);
        if(StringUtils.isEmpty(result)){
            throw new FinalException(EnumInfo.RESULT_ERROR);
        }
        JSONObject object = JSONObject.parseObject(result);
        if(object.getInteger("status") == 200){
            object = object.getJSONObject("data");
        }
        return ReturnInfo.success(object);
    }

    @Override
    public Object queryBySQL(String body) throws Exception {
        String url = config.getProduct_querybysql();
        LOGGER.info("生产力写稿请求地址：" + url);
        String result = HttpClientUtil.postHeader(body , url , null);
        LOGGER.info("生产力写稿后台返回数据：" + result);
        if(StringUtils.isEmpty(result)){
            throw new FinalException(EnumInfo.RESULT_ERROR);
        }
        JSONObject object = JSONObject.parseObject(result);
        JSONArray array = null;
        if("success".equals(object.getString("message"))){
            array = object.getJSONArray("data");
        }
        return ReturnInfo.success(array);
    }
}
