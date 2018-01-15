package com.sobey.controller;

import com.sobey.service.impl.ILayOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by TS on 2017/10/19.
 */
@RestController
public class LayOutController {

    @Autowired
    private ILayOutService layOutService;

    @GetMapping("/allocation/search/{uid}")
    public Object search_id(@PathVariable String uid) throws Exception {
        return layOutService.search_id(uid);
    }

    @PostMapping("/allocation/update")
    public Object updatelayout(@RequestBody String body) throws Exception {
        return layOutService.updatelayout(body);
    }

    @PostMapping("/allocation/upload/{layoutid}")
    public Object uploadImg(MultipartFile file , @PathVariable String layoutid, HttpServletRequest request) throws Exception {
        return layOutService.upload_file(file , layoutid , request);
    }
}
