package com.sobey.controller;
import com.sobey.service.ITopiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopiceController {

    @Autowired
    private ITopiceService service;

    /**
     * 选题查询
     * @param body
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/rest/search/topice")
    public Object searchtopice(@RequestBody String body) throws Exception{
        return service.search(body);
    }
}
