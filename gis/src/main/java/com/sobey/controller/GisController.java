package com.sobey.controller;

import com.sobey.service.IGisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by TS on 2017/9/10.
 */
@RestController
public class GisController {

    @Autowired
    private IGisService service;

    @PostMapping(value = "/rest/gis/interview")
    public Object getintervew(@RequestBody String body) throws Exception {
        return service.getintervew(body);
    }
}
