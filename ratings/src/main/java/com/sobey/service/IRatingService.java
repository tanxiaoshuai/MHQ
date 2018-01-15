package com.sobey.service;

import org.springframework.web.multipart.MultipartFile;

public interface IRatingService {

    /**
     * 添加记录
     * @param body
     * @return
     * @throws Exception
     */
    public Object insert(String body) throws Exception;

    /**
     * 查询
     * @param body
     * @return
     * @throws Exception
     */
    public Object search_list(String body) throws Exception;

    /**
     * 导入excel
     * @param file
     * @return
     * @throws Exception
     */
    public Object ecxelInsert(MultipartFile file) throws Exception;
}
