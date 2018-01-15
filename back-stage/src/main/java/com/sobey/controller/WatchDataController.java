package com.sobey.controller;

import com.sobey.service.impl.IWatchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by TS on 2017/10/18.
 */
@RestController
public class WatchDataController {

    @Autowired
    private IWatchDataService watchDataService;

    @GetMapping("/rest/search/watchdata")
    public Object search_brokenew() throws Exception {
        return watchDataService.getWatchData();
    }

    @PostMapping("/rest/update/watchdata")
    public Object updata(@RequestBody String body) throws Exception {
        return watchDataService.updateWatchData(body);
    }
}
