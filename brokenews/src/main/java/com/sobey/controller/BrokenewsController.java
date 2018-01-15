package com.sobey.controller;

import com.sobey.service.IBrokeNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by TS on 2017/9/27.
 */
@RestController
public class BrokenewsController {

    @Autowired
    private IBrokeNewService service;

    @PostMapping("/rest/brokenews/search")
    public Object search_brokenew(@RequestBody String body) throws Exception {
        return service.search_brokenew(body);
    }

    @GetMapping("/rest/brokenews/statistics")
    public Object broknewstatistics(@RequestParam String groupByField) throws Exception {
        return service.broknewstatistics(groupByField);
    }
}
