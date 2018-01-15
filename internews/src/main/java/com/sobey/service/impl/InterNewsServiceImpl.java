package com.sobey.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sobey.config.BaseInfo;
import com.sobey.config.ConfigUrl;
import com.sobey.entity.InterNews;
import com.sobey.entity.InterNewsDalie;
import com.sobey.exception.FinalException;
import com.sobey.service.IInterNewsService;
import com.sobey.util.BeanFactoryUtil;
import com.sobey.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by TS on 2017/8/30.
 */
@Service
public class InterNewsServiceImpl implements IInterNewsService {

    private final static Logger LOGGER = LoggerFactory.getLogger(InterNewsServiceImpl.class);

    @Autowired
    private ConfigUrl config;

    @Autowired
    private BaseInfo Info;

    @Override
    public List<InterNews> internet_news(String body , String type) throws Exception {
        String url = config.getInternet_news_url();
        JSONObject bodyjson = JSONObject.parseObject(body);
        Integer size = bodyjson.getInteger("pageSize");
        JSONArray sortFields = bodyjson.getJSONArray("sortFields");
        JSONArray sourceIds = bodyjson.getJSONArray("sourceIds");
        if(sortFields == null){
            sortFields = new JSONArray();
            sortFields.add("pubTime desc");
        }
        bodyjson.clear();
        bodyjson.put("size" , size);
        bodyjson.put("sortFields" , sortFields);
        if(sourceIds != null && sourceIds.size() > 0){
            bodyjson.put("sourceIds" , sourceIds);
        }
        LOGGER.info("后台请求参数：" + bodyjson.toJSONString());
        String result = HttpClientUtil.postHeader(bodyjson.toString() , url , null);
        JSONObject object = JSONObject.parseObject(result);
        Integer code = object.getInteger("code");
        if(code != 0){
            throw new FinalException("02" , "后台返回数据为空");
        }
        object = object.getJSONObject("result");
        JSONArray array = object.getJSONArray("records");
        List list = new JSONArray();
        for(int i = 0 ; i < array.size() ; i ++){
            JSONObject obj = array.getJSONObject(i);
            JSONArray a = obj.getJSONArray("pics");
            InterNews interNews = BeanFactoryUtil.getBeanByClass(InterNews.class);
            interNews.setCollectTimel(obj.getString("pubTime"));
            interNews.setFrom(obj.getString("author"));
            interNews.setKeyframeurl((a != null && a.size() > 0) ? (String) a.get(0) : "");
            interNews.setKeywords("");
            interNews.setMaterials(obj.getString("url"));
            interNews.setNid(obj.getString("docId"));
            interNews.setSitename("");
            interNews.setTitle(obj.getString("title"));
            list.add(interNews);
        }
        return list;
    }

    @Override
    public InterNewsDalie internet_news_saerchId(String id, String type) throws Exception {
        JSONObject body = new JSONObject();
        body.put("docId" , id);
        String url = config.getInternet_news_saerchid();
        String result = HttpClientUtil.postHeader(body.toString() , url , null);
        JSONObject object = JSONObject.parseObject(result);
        Integer code = object.getInteger("code");
        if(code != 0){
            throw new FinalException("02" , "后台返回数据为空");
        }
        object = object.getJSONObject("result");
        InterNewsDalie dalie = BeanFactoryUtil.getBeanByClass(InterNewsDalie.class);
        JSONArray a = object.getJSONArray("pics");
        String content = getDescription(object.getString("description") , a);
        dalie.setCollectTimel(object.getString("pubTime"));
        dalie.setFrom(object.getString("src"));
        dalie.setFullText(content);
        dalie.setKeywords("");
        dalie.setMaterials((a != null && a.size() > 0) ? (String) a.get(0) : "");
        dalie.setNid(object.getString("docId"));
        dalie.setSitename("");
        String summary = content.substring(0 , 40).replace("</br>" , "");
        dalie.setSummary(summary.contains(":") ? summary.split(":")[1] : summary);
        dalie.setTitle(object.getString("title"));
        return dalie;
    }

    public String getDescription(String d , List l){
        String str = d.replaceAll("`n`" , "</br>");
        for(Object s : l){
            String st = (String)s;
            str = str.replaceFirst("\\[{2}\\+_\\+\\]{2}" , "");
        }
        return str;
    }
}
