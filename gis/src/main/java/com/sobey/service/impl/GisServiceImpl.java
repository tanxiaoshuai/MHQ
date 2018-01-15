package com.sobey.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sobey.config.BaseInfo;
import com.sobey.config.ConfigUrl;
import com.sobey.dao.GisUserDao;
import com.sobey.entity.Interview;
import com.sobey.exception.FinalException;
import com.sobey.service.IGisService;
import com.sobey.util.EnumInfo;
import com.sobey.util.HttpClientUtil;
import com.sobey.util.ReturnInfo;
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
 * Created by TS on 2017/9/10.
 */
@Service
public class GisServiceImpl implements IGisService {

    private static Logger LOGGER = LoggerFactory.getLogger(GisServiceImpl.class);

    @Autowired
    private ConfigUrl conf;

    @Autowired
    private BaseInfo info;

    /**
     * 查询采访任务
     * @param body
     * @return
     * @throws Exception
     */
    @Override
    public Object getintervew(String body) throws Exception {
        Map map = new HashMap();
        map.put("token" , info.getHivetoken());
        map.put("siteCode" , info.getSitecode());
        LOGGER.info("GIS采访任务查询页面请求参数：" + body);
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
        String result = HttpClientUtil.postHeader(object.toString() , conf.getInterview_search_url() , map);
        LOGGER.info("采访任务后台返回数据：" + result);
        if(StringUtils.isEmpty(result)){
            throw new FinalException(EnumInfo.RESULT_ERROR);
        }
        object = JSONObject.parseObject(result);
        JSONArray array = object.getJSONArray("data");
        String ip = "";
        if(!StringUtils.isEmpty(conf.getImg_ip())){
            ip = (conf.getImg_ip().split(":"))[1].replace("//" , "");
        }
        List<Interview> list = new ArrayList<>();
        for(Object json : array){
            JSONObject ob = (JSONObject) json;
            ob.put("taskprogress" , null);
            ob.put("imgip" , ip);
            Interview view = JSONObject.parseObject(ob.toString() , Interview.class);
            list.add(view);
        }
        return ReturnInfo.success(list);
    }
}
