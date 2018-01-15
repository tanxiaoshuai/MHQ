package com.sobey.service;

/**
 * Created by TS on 2017/9/27.
 */
public interface IBrokeNewService {

    /**
     * 查询爆料
     * @param body
     * @return
     * @throws Exception
     */
    public Object search_brokenew(String body) throws Exception;

    /**
     * 爆料数据分析
     * @return
     * @throws Exception
     */
    public Object broknewstatistics(String groupByField)throws Exception;
}
