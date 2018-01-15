package com.sobey.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sobey.config.BaseInfo;
import com.sobey.config.ConfigUrl;
import com.sobey.entity.Interview;
import com.sobey.exception.FinalException;
import com.sobey.service.IInterviewService;
import com.sobey.util.EnumInfo;
import com.sobey.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TS on 2017/8/31.
 */
@Service
public class InterviewServiceImpl implements IInterviewService {

    private static Logger LOGGER = LoggerFactory.getLogger(InterviewServiceImpl.class);

    @Autowired
    private BaseInfo info;

    @Autowired
    private ConfigUrl url;


    @Override
    public List<Interview> search(String body) throws Exception {
        Map map = new HashMap();
        map.put("token" , info.getHivetoken());
        map.put("siteCode" , info.getSitecode());
        LOGGER.info("采访任务查询页面请求参数：" + body);
        JSONObject object = JSONObject.parseObject(body);
        String starttime = object.getString("starttime");
        String endtime = object.getString("endtime");
        boolean isdesc = object.getBoolean("isdesc");
        String page = object.getString("page");
        String size = object.getString("size");
        object.clear();

        JSONObject sort = new JSONObject();
        sort.put("field" , "createTime");
        sort.put("desc" , isdesc);

        JSONObject date = new JSONObject();
        date.put("field" , "createTime");
        date.put("start" , starttime);
        date.put("end" , endtime);
        object.put("page" , page);
        object.put("size" , size);
        object.put("date" , date);
        object.put("sort" , sort);
        object.put("search" , new JSONObject());

        LOGGER.info("采访任务后台请求参数：" + JSONObject.toJSONString(object , true));
        String result = HttpClientUtil.postHeader(object.toString() , url.getInterview_search_url() , map);
        LOGGER.info("采访任务后台返回数据：" + result);
        if(StringUtils.isEmpty(result)){
            throw new FinalException(EnumInfo.RESULT_ERROR);
        }
        object = JSONObject.parseObject(result);
        JSONArray array = object.getJSONArray("data");
        String ip = "";
        if(!StringUtils.isEmpty(url.getImg_ip())){
            ip = (url.getImg_ip().split(":"))[1].replace("//" , "");
        }
        List<Interview> list = new ArrayList<>();
        for(Object json : array){
            JSONObject ob = (JSONObject) json;
            String uuid = ob.getString("uuid");
            ob.put("taskprogress" , taskProgress(uuid));
            JSONArray resMaterial = ob.getJSONArray("resMaterial");

            JSONArray urlarr = new JSONArray();
            if(resMaterial != null && resMaterial.size() > 0){
                for(Object tep : resMaterial){
                    JSONObject tm = (JSONObject) tep;
                    JSONArray keyFrameUrl = tm.getJSONArray("keyFrameUrl");
                    if(keyFrameUrl != null){
                        for(Object key : keyFrameUrl){
                            String url_ = ((String) key);
                            if(url_.contains("${REQUEST_IP}")){
                                url_ = ((String) key).replace("${REQUEST_IP}" , ip);
                            }
                            urlarr.add(url_);
                        }
                    }
                }
            }
            ob.put("resMaterial" , urlarr);
            Interview view = JSONObject.parseObject(ob.toString() , Interview.class);
            list.add(view);
        }
        return list;
    }

    /**
     * 任务轨迹
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Object taskProgress(String id) throws Exception {
        Map map = new HashMap();
        map.put("token" , info.getHivetoken());
        map.put("siteCode" , info.getSitecode());
        String url_ = url.getTaskprogress_url() + id;
        LOGGER.info("采访任务轨迹查询请求地址["+ url_ +"]");
        String result = HttpClientUtil.getHeader(url_ , map);
        if(StringUtils.isEmpty(result)){
            throw new FinalException(EnumInfo.RESULT_ERROR);
        }
        JSONObject object = JSONObject.parseObject(result);
        LOGGER.info("采访任务轨迹查询后台返回数据：" + result);
        JSONArray array = object.getJSONArray("data");
        if(array == null || array.size() == 0){
            return null;
        }
        for(Object obj : array){
            JSONObject json = (JSONObject) obj;
            String operatorName = json.getString("operatorName");
            String updateTime = json.getString("updateTime");
            Integer statu = json.getInteger("statu");
            String statuName = null;
            if(statu == 10){
                operatorName = json.getString("creatorCode");
                statuName = "创建任务";
            }
            if(statu == 6){
                statuName = "认领任务";
            }
            if(statu == 7){
                statuName = "完成任务";
            }
            json.clear();
            json.put("operatorName" , operatorName);
            json.put("updateTime" , updateTime);
            json.put("statuName" , statuName);
        }
        return array;
    }
}
