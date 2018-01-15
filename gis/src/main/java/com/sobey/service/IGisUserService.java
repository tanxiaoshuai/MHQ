package com.sobey.service;

import com.sobey.model.GisUesr;

public interface IGisUserService {

    /**
     * 获取记者列表
     * @return
     * @throws Exception
     */
    public Object getReports() throws Exception;

    /**
     * 添加记者
     * @return
     * @throws Exception
     */
    public Object insertReport(GisUesr user) throws Exception;


}
