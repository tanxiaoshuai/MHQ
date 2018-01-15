package com.sobey.service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sobey.config.BaseInfo;
import com.sobey.config.ConfigUrl;
import com.sobey.entity.MaterialList;
import com.sobey.entity.Topice;
import com.sobey.exception.FinalException;
import com.sobey.util.BeanFactoryUtil;
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

@Service
public class TopiceServiceImpl implements ITopiceService {

    private static Logger LOGGER = LoggerFactory.getLogger(TopiceServiceImpl.class);

    @Autowired
    private BaseInfo info;

    @Autowired
    private ConfigUrl url;

    /**
     * 按条件 查询选题
     * @param body
     * @return
     * @throws Exception
     */
    @Override
    public Object search(String body) throws Exception {
        LOGGER.info("选题请求地址：" + url.getTopice_url());
        Map map = new HashMap();
        map.put("token" , info.getHivetoken());
        map.put("siteCode" , info.getSitecode());
        JSONObject object = JSONObject.parseObject(body);
        String page = object.getString("page");
        String size = object.getString("size");
        boolean isdesc = object.getBoolean("isdesc");
        String starttime = object.getString("starttime");
        String endtime = object.getString("endtime");
//        String status = object.getString("status");
        object.clear();

        JSONObject queryCondition = new JSONObject();
        queryCondition.put("page" , page);
        queryCondition.put("size" , size);
        JSONArray sortBys = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("fieldName" , "createDate_");
        obj.put("isdesc" , isdesc);
        sortBys.add(obj);
        queryCondition.put("sortBys" , sortBys);
        JSONObject fieldConditionGroup = new JSONObject();
        fieldConditionGroup.put("relation" , "AND");
        JSONArray fieldConditions = new JSONArray();
        if(!StringUtils.isEmpty(starttime) && !StringUtils.isEmpty(endtime)){
            JSONObject start = new JSONObject();
            start.put("field" , "createDate_");
            start.put("operation" , "GREATERTHAN");
            start.put("value" , starttime);
            fieldConditions.add(start);
            JSONObject end = new JSONObject();
            end.put("field" , "createDate_");
            end.put("operation" , "LESSTHAN");
            end.put("value" , endtime);
            fieldConditions.add(end);
        }
        fieldConditionGroup.put("fieldConditions" , fieldConditions);
        queryCondition.put("fieldConditionGroup" , fieldConditionGroup);
        object.put("queryCondition" , queryCondition);
        LOGGER.info("选题后台请求参数：" + object);

        String result = HttpClientUtil.postHeader(object.toString() , url.getTopice_url() , map);
        LOGGER.info("选题后台返回数据：" + result);
        if(StringUtils.isEmpty(result)){
            throw new FinalException(EnumInfo.RESULT_ERROR);
        }
        object.clear();
        object = JSONObject.parseObject(result);
        JSONArray array = object.getJSONArray("data");

        Integer totalCount = object.getInteger("totalCount");
        Integer totalPage = object.getInteger("totalPage");
        List listArr = new JSONArray();
        if(array != null){
            for(Object json : array){
                JSONObject jsonObject = (JSONObject) json;
                String id = jsonObject.getString("contentId_");
                JSONObject js = (JSONObject) search_task(id);

                JSONObject extend = jsonObject.getJSONObject("extend");
                Topice topice = BeanFactoryUtil.getBeanByClass(Topice.class);
                topice.setAssignstate(js.getInteger("state"));
                topice.setContentId(jsonObject.getString("contentId_"));
                topice.setCreateDate(jsonObject.getString("createDate_"));
                topice.setCreateUserCode(jsonObject.getString("createUser_"));
                topice.setCreateUserName(extend.getString("createUserName"));
                topice.setExaminestatus(extend.getInteger("status"));
                topice.setInfo(js.getInteger("info"));
                topice.setContent(extend.getString("content"));
                topice.setInternation(js.getInteger("internation"));
                topice.setInterview(js.getInteger("interview"));
                JSONArray materialList = jsonObject.getJSONArray("materialList");

                List list = new ArrayList();
                if(materialList != null && materialList.size() > 0){
                    for(Object mater : materialList){
                        JSONObject ob = (JSONObject) mater;
                        MaterialList ma = BeanFactoryUtil.getBeanByClass(MaterialList.class);
                        ma.setType(ob.getString("type"));
                        ma.setContentId(ob.getString("contentId"));
                        ma.setKeyFrameUrl(ob.getJSONArray("keyFrameUrl"));
                        ma.setStreamMediaUrl(ob.getJSONArray("streamMediaUrl"));
                        ma.setName(ob.getString("name"));
                        list.add(ma);
                    }
                }
                topice.setMaterlist(list);
                topice.setMaterialCount(jsonObject.getInteger("materialCount"));
                topice.setTitle(jsonObject.getString("name_"));
                listArr.add(topice);
            }
        }
        JSONObject job = new JSONObject();
        job.put("result" , listArr);
        job.put("totalCount" , totalCount);
        job.put("totalPage" , totalPage);
        return ReturnInfo.success(job);
    }

    /**
     * 查询指派
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Object search_task(String id) throws Exception {
        Map map = new HashMap();
        map.put("token" , info.getHivetoken());
        map.put("siteCode" , info.getSitecode());

        int INFO = 0;
        int ARTICLEEDITOR = 0;
        int INTERVIEW = 0;
        int state = 0;
        String url_ = url.getTopice_task_url() + id;
        LOGGER.info("选题指派查询请求地址：" + url_);
        String result = HttpClientUtil.getHeader(url_ , map);
        if(StringUtils.isEmpty(result)){
            throw new FinalException(EnumInfo.RESULT_ERROR);
        }
        JSONObject object = JSONObject.parseObject(result);
        JSONArray array = object.getJSONArray("result");
        if(array != null && array.size()>0){
            state = 1;
            for(Object obj : array){
                JSONObject json = (JSONObject) obj;
                String taskType = json.getString("taskType");
                if(taskType.equals("INFO")){
                    INFO = 1;
                }
                if(taskType.equals("ARTICLEEDITOR")){
                    ARTICLEEDITOR = 1;
                }
                if(taskType.equals("INTERVIEW")){
                    INTERVIEW = 1;
                }
            }
        }
        object.clear();
        object.put("state" , state);
        object.put("internation" , ARTICLEEDITOR);
        object.put("interview" , INTERVIEW);
        object.put("info" , INFO);
        return object;
    }
}
