package com.sobey.service;

import com.sobey.entity.Interview;

import java.util.List;

/**
 * Created by TS on 2017/8/31.
 */
public interface IInterviewService {

    /**
     * 查询采访列表
     * @param body
     * @return
     * @throws Exception
     */
    public List<Interview> search(String body) throws Exception;

    /**
     * 查询任务轨迹
     * @param id
     * @return
     * @throws Exception
     */
    public Object taskProgress(String id) throws Exception;
}
