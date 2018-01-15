package com.sobey.service.impl;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by TS on 2017/10/19.
 */
public interface ILayOutService {

    /**
     * 获取配置信息
     * @param uid
     * @return
     * @throws Exception
     */
    public Object search_id(String uid) throws Exception;

    /**
     * 修改配置
     * @param body
     * @return
     * @throws Exception
     */
    public Object updatelayout(String body) throws Exception;

    /**
     * 上传图片
     * @param file
     * @param id
     * @param request
     * @return
     * @throws Exception
     */
    public Object upload_file(MultipartFile file, String id, HttpServletRequest request)throws Exception;
}
