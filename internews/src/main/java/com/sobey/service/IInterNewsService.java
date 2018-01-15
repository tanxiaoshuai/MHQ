package com.sobey.service;

import com.sobey.entity.InterNews;
import com.sobey.entity.InterNewsDalie;

import java.util.List;

/**
 * Created by TS on 2017/8/30.
 */
public interface IInterNewsService {

    /**
     * 互联网新闻
     * @param body
     * @return
     */
    public List<InterNews> internet_news(String body, String type) throws Exception;

    /**
     * 按ID查询互联网新闻详情
     * @param id
     * @return
     */
    public InterNewsDalie internet_news_saerchId(String id, String type) throws Exception;

}
