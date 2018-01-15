package com.sobey.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by TS on 2017/7/27.
 */
public class ModleUtil {

    /**
     * 构造pgc请求数据
     * @param body
     * @return
     */
    public static JSONObject resource_upload_modle(String body){
        JSONObject jsonBody = JSONObject.parseObject(body);
        JSONObject json = new JSONObject();//最外层
        json.put("size" , jsonBody.getString("size"));
        json.put("page" , jsonBody.getString("page"));
        JSONArray sortBys = new JSONArray();//按时间降序排列

        JSONObject obj = new JSONObject();
        obj.put("fieldName" , "createDate_");
        obj.put("isDesc" , true);
        sortBys.add(obj);

        JSONArray conditions = new JSONArray();
        JSONObject type = new JSONObject();
        type.put("field" , "clipsource");
        type.put("nexus" , "and");
        type.put("value" , jsonBody.getString("type"));

        JSONObject date = new JSONObject();
        date.put("field" , "createDate_");
        date.put("nexus" , "and");
        date.put("value" , "["+ jsonBody.getString("startDate")+" TO "+ jsonBody.getString("endDate") +"]");
        conditions.add(type);
        conditions.add(date);
        json.put("sortBys" , sortBys);
        json.put("conditions" , conditions);
        return json;
    }

    /**
     * 按id查询pgc
     * @param body
     * @return
     */
    public static JSONObject upload_saerchId(String body){
        JSONObject object = JSONObject.parseObject(body);
        JSONObject obj = new JSONObject();
        obj.put("size" , 1);
        JSONArray arr = new JSONArray();
        JSONObject json = new JSONObject();
        json.put("field" , "contentId_");
        json.put("nexus" , "and");
        json.put("value" , object.getString("contentId"));
        arr.add(json);
        obj.put("conditions" , arr);
        JSONArray sortBys = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fieldName" , "createDate_");
        jsonObject.put("isDesc" , true);
        obj.put("sortBys" , sortBys);
        return obj;
    }

    public static void main(String[] args){
        String body = "{\n" +
                "\t\"contentId\":\"92ba818f7d94494cbc752053ac0c0904\"\n" +
                "}";
//        System.out.print(JSONObject.parseObject(body));
        System.out.print(upload_saerchId(body));
    }

}
