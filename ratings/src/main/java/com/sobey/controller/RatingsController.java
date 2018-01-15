package com.sobey.controller;
import com.sobey.service.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RatingsController {

    @Autowired
    private IRatingService service;

    @PostMapping(value = "/ratings/search")
    public Object search_list(@RequestBody String body) throws Exception{
        return service.search_list(body);
    }

    @PostMapping(value = "/ratings/add")
    public Object search_add(@RequestBody String body) throws Exception{
        return service.insert(body);
    }

    @PostMapping(value = "/ratings/excel")
    public Object insert_excel(MultipartFile file)throws Exception{
        return service.ecxelInsert(file);
    }
}
