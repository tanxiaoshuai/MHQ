package com.sobey.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sobey.config.BaseInfo;
import com.sobey.config.ConfigUrl;
import com.sobey.entity.Upload;
import com.sobey.entity.UploadContent;
import com.sobey.service.IUploadService;
import com.sobey.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TS on 2017/8/30.
 */
@Service
public class UploadServiceImpl implements IUploadService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UploadServiceImpl.class);

    @Autowired
    private ConfigUrl config;

    @Autowired
    private BaseInfo info;

    /**
     * 资源上传（pgc , vtube , localupload）
     * @param body
     * @return
     */
    @Override
    public Object resource_upload(String body) throws Exception {

        JSONObject content = JSONObject.parseObject(body);

        String type_ = content.getString("type_");
        content.remove("type_");
        JSONObject bodyJson = null;
        if(StringUtils.isEmpty(content.getString("contentId"))){
            bodyJson = ModleUtil.resource_upload_modle(body);
        }
        if(!StringUtils.isEmpty(content.getString("contentId"))){
            bodyJson = ModleUtil.upload_saerchId(body);
        }
        //构造请求数据
        LOGGER.info("手机上传请求参数：" + bodyJson);
        StringBuffer buffer = new StringBuffer();
        buffer.append(config.getResource_upload_url());
        buffer.append("?token=");
        buffer.append(info.getHivetoken());
        buffer.append("&siteCode=");
        buffer.append(info.getSitecode());
        LOGGER.info("查询手机上传地址：["+buffer.toString()+"]");
        String result = HttpClientUtil.postHeader(bodyJson.toString() , buffer.toString() , null);
        LOGGER.info("查询手机上传后台返回数据：" + result);
        JSONObject json = JSONObject.parseObject(result);

        if(!json.getBoolean("success")){
            LOGGER.error("手机上传返回数据失败：[" + result + "]");
            JSONObject error = JSONObject.parseObject(result).getJSONObject("error");
            return ReturnInfo.error(error.getString("code") , error.getString("title"));
        }
        JSONObject data = json.getJSONObject("data");
        JSONObject queryResult = data.getJSONObject("queryResult");
        JSONArray dataArr = queryResult.getJSONArray("data");
        String total = queryResult.getString("recordTotal");

        List<UploadContent> newArr = new ArrayList<>();
        for(Object obj : dataArr){
            JSONObject ob = (JSONObject)obj;
            JSONObject newJson = new JSONObject();
            String contentId = ob.getString("contentId");
            newJson.put("createUser" , StringUtils.isEmpty(ob.getString("createUser")) ? ob.getString("storagedUser") : ob.getString("createUser"));//创建人
            newJson.put("fileType" , ob.getString("type"));//文件类型
            newJson.put("contentId" , contentId);
            newJson.put("name" , ob.getString("name"));

            JSONObject dynamicResponse = ob.getJSONObject("dynamicResponse");
            String fileCount = dynamicResponse.getString("fileCount_");
            fileCount = StringUtils.isEmpty(fileCount) ? "0" : fileCount;
            newJson.put("clipsource" , dynamicResponse.getString("clipsource"));//类型
            newJson.put("fileCount" , fileCount);//文件数量
            newJson.put("lastUpdateDate" , dynamicResponse.getString("lastUpdateDate_"));//最后上传时间
            String previewFile = ob.getString("keyframe");
            if(previewFile.contains("http://")){
                previewFile = ob.getString("keyframe");
            }else {
                previewFile = config.getImg_ip() + ob.getString("keyframe");
            }
            JSONArray pathList = new JSONArray();
            if(!StringUtils.isEmpty(previewFile)){
                pathList.add(previewFile);
            }
            LOGGER.info("后台返回数==========据：" + JSONObject.toJSONString(newJson));
            //判断 多个文件  单独查询图片列表
            if(Integer.parseInt(fileCount) > 1 && "tel_pgc".equals(type_)){
                pathList.clear();
                String url = config.getUpload_path_saerch() + "&contentId=" + contentId + "&token=" + info.getHivetoken() ;
                LOGGER.info("查询地址列表请求地址:["+ url +"]");
                String resultId = HttpClientUtil.getHeader(url , null);
                JSONObject objId = JSONObject.parseObject(resultId);
                if(!objId.getBoolean("success")){
                    LOGGER.info("查询地址列表失败，返回信息如下：" + resultId);
                }
                JSONArray array = objId.getJSONObject("data").getJSONArray("paths");
                array = array == null ? new JSONArray() : array;
                for (Object arr : array){
                    JSONObject object = (JSONObject)arr;
                    String filePath = object.getString("filePath");
                    if(filePath.contains("http://")){
                        pathList.add(object.getString("filePath"));
                    }else {
                        pathList.add(config.getTpp_ip() + object.getString("filePath"));
                    }
                }
            }
            newJson.put("pathList" , pathList);
            UploadContent upload = JSONObject.parseObject(newJson.toString() , UploadContent.class);
            newArr.add(upload);
        }
        content.clear();
        Upload up = BeanFactoryUtil.getBeanByClass(Upload.class);
        up.setTotal(Integer.parseInt(StringUtils.isEmpty(total) ? "0" : total));
        up.setResult(newArr);
        return ReturnInfo.success(up);
    }


    /**
     * pgc上传回掉函数
     * @param body
     * @return
     * @throws Exception
     */
    @Override
    public Object call_back(String body) throws Exception {
        JSONObject object = JSONObject.parseObject(body);
        String code = object.getString("code");
        if(!"00".equals(code)){
            LOGGER.info("pgc上传失败");
            return ReturnInfo.error(EnumInfo.PGC_UPLOAD_CODE);
        }
        String contentId = object.getString("contentId");
        String type_ = object.getString("type_");
        JSONObject content = new JSONObject();
        content.put("contentId" , contentId);
        content.put("type_" , type_);
        Object result = resource_upload(content.toString());
        LOGGER.info("推送字串" + JSON.toJSONString(result));
        MyWebSocket.sendInfo(JSON.toJSONString(result));
        return ReturnInfo.success();
    }
}
