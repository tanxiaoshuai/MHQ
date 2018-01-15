package com.sobey.controller;
import com.sobey.service.IInterNewsService;
import com.sobey.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by TS on 2017/8/30.
 */
@RestController
public class InterNewsController {

    @Autowired
    private IInterNewsService service;

    /**
     * 互联网新闻
     * @param body
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/rest/internet/news")
    public Object internet_news(@RequestBody String body , String type) throws Exception{
        return ReturnInfo.success(service.internet_news(body , type));
    }

    /**
     * 互联网新闻id查询
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/rest/internet/saerchId")
    public Object internet_news_saerchId(@RequestParam String id , String type) throws Exception{
        return ReturnInfo.success(service.internet_news_saerchId(id , type));
    }
}
