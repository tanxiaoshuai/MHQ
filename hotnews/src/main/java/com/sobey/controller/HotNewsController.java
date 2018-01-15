package com.sobey.controller;

import com.sobey.service.IHotNewsService;
import com.sobey.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by TS on 2017/9/9.
 */
@RestController
public class HotNewsController {

    @Autowired
    private IHotNewsService hotNewsService;
    /**
     * 实时热点新新闻
     * @param body
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/rest/hot/news")
    public Object hot_news(@RequestBody String body) throws Exception{
        return ReturnInfo.success(hotNewsService.hot_news(body));
    }
}
