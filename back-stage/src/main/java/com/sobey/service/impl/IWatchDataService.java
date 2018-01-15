package com.sobey.service.impl;

/**
 * Created by TS on 2017/10/18.
 */
public interface IWatchDataService {

    /**
     * 获取值班信息
     * @return
     * @throws Exception
     */
    public Object getWatchData() throws Exception;

    /**
     * 修改值班信息
     * @param body
     * @return
     * @throws Exception
     */
    public Object updateWatchData(String body) throws Exception;
}
