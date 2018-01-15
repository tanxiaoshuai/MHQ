package com.sobey.controller;
import com.sobey.service.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by TS on 2017/8/30.
 */
@RestController
public class UploadController {

    @Autowired
    private IUploadService service;
    /**
     * 上传接口（pgc , vtube , localupload）
     * @param body
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/rest/uploadPgc")
    public Object resource_upload(@RequestBody String body) throws Exception{
        return service.resource_upload(body);
    }

    @PostMapping(value = "/rest/upload/callback")
    public Object call_back(@RequestBody String body) throws Exception{
        return service.call_back(body);
    }
}
