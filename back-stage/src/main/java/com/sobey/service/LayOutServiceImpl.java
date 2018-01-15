package com.sobey.service;

import com.alibaba.fastjson.JSONObject;
import com.sobey.dao.LayOutDao;
import com.sobey.exception.FinalException;
import com.sobey.model.LayOut;
import com.sobey.service.impl.ILayOutService;
import com.sobey.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by TS on 2017/10/19.
 */
@Service
public class LayOutServiceImpl implements ILayOutService {

    @Autowired
    private LayOutDao layOutDao;

    @Override
    public Object search_id(String uid) throws Exception {
        LayOut layOut = layOutDao.search_id(uid);
        return ReturnInfo.success(layOut);
    }

    @Override
    public Object updatelayout(String body) throws Exception {
        LayOut layOut = JSONObject.parseObject(body , LayOut.class);
        layOutDao.updatelayout(layOut);
        return ReturnInfo.success();
    }

    /**
     * 文件上传
     * @param file
     * @return
     */
    @Override
    public Object upload_file(MultipartFile file , String id, HttpServletRequest request) throws Exception {
        //文件名
        String fileName = file.getOriginalFilename();
        StringBuffer name = new StringBuffer();
        name.append(UUID.randomUUID().toString().replace("-" , ""));
        name.append(fileName.substring(fileName.lastIndexOf(".")));
        //新建文件名
        fileName = name.toString();
        String srcName = request.getContextPath();
        String path =request.getSession().getServletContext().getRealPath("").replace(srcName.replace("/" , "") , "img") + fileName;
        File saveDir = new File(path);
        if (!saveDir.getParentFile().exists()){
            saveDir.getParentFile().mkdirs();
        }
        // 转存文件
        try {
            file.transferTo(saveDir);
        } catch (IOException e) {
            throw new FinalException("02" , saveDir.getParentFile() + " 文件路径不存在");
        }
        String url = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + "/img/" + fileName;
        layOutDao.updateImg(url , id);
        JSONObject object = new JSONObject();
        object.put("backgroundurl" , url);
        return ReturnInfo.success(object);
    }
}
