package com.sobey.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sobey.config.BaseInfo;
import com.sobey.config.ConfigUrl;
import com.sobey.exception.FinalException;
import com.sobey.util.HttpClientUtil;
import com.sobey.util.ReturnInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TS on 2017/9/27.
 */
@Service
public class BrokeNewService implements IBrokeNewService {

    public static Logger LOGGER  = LoggerFactory.getLogger(BrokeNewService.class);

    @Autowired
    private ConfigUrl configUrl;

    @Autowired
    private BaseInfo info;

    @Override
    public Object search_brokenew(String body) throws Exception {
        Map map = new HashMap();
        map.put("token" , info.getHivetoken());
        map.put("siteCode" , info.getSitecode());
        JSONObject object = JSONObject.parseObject(body);
        String starttime = object.getString("starttime");//开始时间
        String endtime = object.getString("endtime");//结束时间
        Integer page = object.getInteger("page");//当前页码
        Integer size = object.getInteger("size");//长度
        boolean desc = object.getBoolean("desc");//是否降序

        JSONObject createtime = new JSONObject();//封装时间
        createtime.put("start" , starttime);
        createtime.put("end" , endtime);

        JSONObject sortBy = new JSONObject();//排序
        sortBy.put("sort" , "createtime");
        sortBy.put("desc" , true);
        object.clear();

        object.put("page" , page);
        object.put("size" , size);
        object.put("createtime" , createtime);
        object.put("sortBy" , sortBy);

        LOGGER.info("电话爆料请求地址：" + configUrl.getBroke_news() +"\n" + "请求参数：" + object);

        String result = HttpClientUtil.postHeader(object.toString() , configUrl.getBroke_news() , map);
        LOGGER.info("电话爆料后台请求参数返回数据：" + result);
        if(StringUtils.isEmpty(result)){
            throw new FinalException("01" , "电话爆料后台返回数据为空");
        }
        JSONObject data = JSONObject.parseObject(result).getJSONObject("data");
        JSONArray entities = data.getJSONArray("entities");
        Integer totalCount = data.getInteger("totalCount");
        Integer totalPage = data.getInteger("totalPage");
        JSONObject extend = data.getJSONObject("extend");
        data.clear();
        data.put("array" , entities);
        data.put("count" , totalCount);
        data.put("totalpage" , totalPage);
        data.put("toDayCount" , extend.getString("toDayCount"));
        return ReturnInfo.success(data);
    }

    @Override
    public Object broknewstatistics(String groupByField) throws Exception {
        Map map = new HashMap();
        map.put("token" , info.getHivetoken());
        map.put("siteCode" , info.getSitecode());
        String url = configUrl.getBroke_statistics().replace("{groupByField}",groupByField);
        LOGGER.info("爆料分析接口地址：" + url);
        String result = HttpClientUtil.postHeader("" , url , map);
        LOGGER.info("电话爆料后台请求参数返回数据：" + result);
        JSONObject object = JSONObject.parseObject(result);
        if(200 != object.getInteger("status")){
            throw new FinalException("01" , "电话爆料后台返回错误");
        }
        JSONObject jsonObject = getsystem(groupByField);
        JSONArray array = jsonObject.getJSONArray("data");
        JSONArray arr = object.getJSONArray("data");
        for(Object o : arr){
            JSONObject ob = (JSONObject) o;
            for(Object io : array){
                JSONObject os = (JSONObject) io;
                String groupValue = ob.getString("groupValue");
                if(StringUtils.isEmpty(groupValue)){
                    break;
                }
                if(groupValue.equals(os.getString("id"))){
                    ob.put("groupValue" , os.getString("name"));
                    break;
                }
            }
        }
        return ReturnInfo.success(arr);
    }

    public JSONObject getsystem(String type) throws IOException {
        if("category".equals(type)){
            type = "bdxs_categories";
        }
        if("source".equals(type)){
            type = "bdxs_sourcesystem";
        }
        Map map = new HashMap();
        map.put("token" , info.getHivetoken());
        map.put("siteCode" , info.getSitecode());
        String result = HttpClientUtil.getHeader(configUrl.getBroke_fl().replace("{type}" , type) , map);
        LOGGER.info("电话爆料获取基础数据请求地址：" + configUrl.getBroke_fl().replace("{type}" , type));
        if(StringUtils.isEmpty(result)){
            throw new FinalException("01" , "电话爆料获取基础数据后台返回数据为空");
        }
        return JSONObject.parseObject(result);
    }
}
