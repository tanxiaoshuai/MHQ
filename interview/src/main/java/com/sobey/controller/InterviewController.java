package com.sobey.controller;
import com.sobey.service.IInterviewService;
import com.sobey.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by TS on 2017/8/31.
 */
@RestController
public class InterviewController {

    @Autowired
    private IInterviewService service;

    @PostMapping(value = "/rest/search/interview")
    public Object search(@RequestBody String body) throws Exception{
        return ReturnInfo.success(service.search(body));
    }
}
