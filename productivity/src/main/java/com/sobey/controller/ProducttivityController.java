package com.sobey.controller;

import com.sobey.service.IproducttivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducttivityController {

    @Autowired
    private IproducttivityService service;

    @GetMapping(value = "/product/publish/{type}")
    public Object publish(@PathVariable String type) throws Exception {
        return service.publish(type);
    }

    @GetMapping(value = "/product/newest/{type}")
    public Object newest(@PathVariable String type) throws Exception {
        return service.newest(type);
    }

    @PostMapping(value = "/product/queryBySQL")
    public Object queryBySQL(@RequestBody String body) throws Exception {
        return service.queryBySQL(body);
    }
}
