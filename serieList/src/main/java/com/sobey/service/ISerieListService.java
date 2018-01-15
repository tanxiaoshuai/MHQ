package com.sobey.service;

public interface ISerieListService {

    /**
     * 根据id查询串联单
     * @return
     * @throws Exception
     */
    public Object search_id(String id, boolean doctype, String type) throws Exception;

    /**
     * 查询列表
     * @param startTime
     * @param endTime
     * @param cloumid
     * @return
     * @throws Exception
     */
    public Object search_list(String startTime, String endTime, String cloumid, String type) throws Exception;
}
