package com.sobey;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sobey.config.BaseInfo;
import com.sobey.config.ConfigUrl;
import com.sobey.entity.HotNews;
import com.sobey.exception.FinalException;
import com.sobey.service.IHotNewsService;
import com.sobey.util.DateUtil;
import com.sobey.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TS on 2017/9/8.
 */
@Service
public class HotNewsServiceImpl implements IHotNewsService {

    private final static Logger LOGGER = LoggerFactory.getLogger(HotNewsServiceImpl.class);

    @Autowired
    private BaseInfo info;

    @Autowired
    private ConfigUrl conf;

    /**
     * 查询热点新闻
     * @param body
     * @return
     * @throws Exception
     *{"geoName":"","offset":"1","size":"8","fromDt":"2017090800","toDt":"2017090823"}
     */
    @Override
    public List<HotNews> hot_news(String body) throws Exception {
        LOGGER.info("实时热点新闻请求参数：" + body);
        JSONObject object = JSONObject.parseObject(body);
        object.put("access_token" , info.getHxytoken());
        StringBuffer buffer = new StringBuffer();
        for(String key : object.keySet()){
            if(StringUtils.isEmpty(object.getString(key))) continue;
            buffer.append(key);
            buffer.append("=");
            buffer.append(object.getString(key));
            buffer.append("&");
        }
        String param = buffer.substring(0 , buffer.length()-1);
        String url = conf.getHot_news() + "?" + param;
        LOGGER.info("实时热点新闻请求地址：" + url);
        String result = HttpClientUtil.getHeader(url , null);
        if(StringUtils.isEmpty(result)){
            LOGGER.info("实时热点新闻 http 后台请求返回数据为空");
            throw new FinalException("02","http 后台请求返回数据为空");
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        Integer code = jsonObject.getInteger("code");

        if(code != 0) throw new FinalException("02" , jsonObject.getString("msg"));
        String geoName = object.getString("geoName");
        geoName = StringUtils.isEmpty(geoName) ? "中国" : geoName;
        JSONArray array = jsonObject.getJSONObject("result").getJSONArray(geoName);

        List<HotNews> list = new ArrayList<>();
        for(Object obj : array){
            JSONObject json = (JSONObject) obj;
            json.put("dt" , DateUtil.longForDate(json.getLong("dt")));
            HotNews hot = JSONObject.parseObject(json.toString() , HotNews.class);
            list.add(hot);
        }
        return list;
    }

}
