package com.sobey.service;

import com.sobey.entity.HotNews;

import java.util.List;

/**
 * Created by TS on 2017/8/30.
 */
public interface IHotNewsService {

    /**
     * 实时热点新新闻
     * @return
     * @throws Exception
     */
    public List<HotNews> hot_news(String body)throws Exception;
}
