package com.sobey.service;

public interface ITopiceService {

    /**
     * 按条件 查询选题
     * @param body
     * @return
     * @throws Exception
     */
    public Object search(String body) throws Exception;


    /**
     * 查询选题指派
     * @param id
     * @return
     * @throws Exception
     */
    public Object search_task(String id)throws Exception;
}
