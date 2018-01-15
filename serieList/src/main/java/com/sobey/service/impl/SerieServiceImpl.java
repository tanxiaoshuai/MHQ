package com.sobey.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sobey.config.ConfigUrl;
import com.sobey.exception.FinalException;
import com.sobey.service.ISerieListService;
import com.sobey.util.EnumInfo;
import com.sobey.util.HttpClientUtil;
import com.sobey.util.ReturnInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.net.URLEncoder;

/**
 * Created by TS on 2017/9/12.
 */
@Service
public class SerieServiceImpl implements ISerieListService {


    private static Logger LOGGER = LoggerFactory.getLogger(SerieServiceImpl.class);

    @Autowired
    private ConfigUrl url;

    /**
     * 根据查询
     * @return
     * @throws Exception
     */
    @Override
    public Object search_id(String id , boolean doctype , String type) throws Exception {
        String geturl = null;
        if(type.equals("ns")){
            geturl = url.getSerie_list_searchid_url_ns();
        }
        if(type.equals("mch")){
            geturl = url.getSerie_list_searchid_url_mch();
        }
        String url_ = geturl.replace("{id}" , id);
        LOGGER.info("查询串联单详情地址：" + url_);
        String result = HttpClientUtil.getHeader(url_ , null);
//        LOGGER.info("后台返回数据：" + result);
        if(StringUtils.isEmpty(result)){
            throw new FinalException(EnumInfo.RESULT_ERROR);
        }
        JSONObject json = JSONObject.parseObject(result);
        if(doctype) return json;
        JSONObject object = json.getJSONObject("list");
        JSONArray arry = object.getJSONArray("parentList");
        for(int i= 0 ; i < arry.size() ; i ++){
            JSONObject obj = arry.getJSONObject(i).getJSONObject("doc");
            String docsubtype = obj.getString("docsubtype");
            if("102".equals(docsubtype)){
                arry.remove(i);
                i--;
            }
        }
        return json;
    }

    @Override
    public Object search_list(String startTime, String endTime, String cloumid , String type) throws Exception {
        String geturl = null;
        if(type.equals("ns")){
            geturl = url.getSerie_search_ns();
        }
        if(type.equals("mch")){
            geturl = url.getSerie_search_mch();
        }
        String url_ = geturl
                .replace("{columid}" , cloumid)
                .replace("{startTime}" , URLEncoder.encode(startTime ,"utf-8"))
                .replace("{endTime}" , URLEncoder.encode(endTime ,"utf-8"));
        LOGGER.info("串联单请求地址：" + url_);
        String result = HttpClientUtil.getHeader(url_ , null);
        if(StringUtils.isEmpty(result)){
            throw new FinalException(EnumInfo.RESULT_ERROR);
        }
        if(type.equals("ns")){
            return ReturnInfo.success(JSONObject.parseObject(result).getJSONArray("llist"));
        }
        JSONArray array = JSONArray.parseArray(result);
        LOGGER.info("串联单列表后台返回数据：" + array.toJSONString());
        return ReturnInfo.success(array);
    }
}
