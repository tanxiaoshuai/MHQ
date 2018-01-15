package com.sobey.controller;
import com.sobey.service.ISerieListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SerieListController {

    @Autowired
    private ISerieListService service;

    @GetMapping(value = "/rest/searchId")
    public Object search_list(@RequestParam String id , @RequestParam boolean doctype ,@RequestParam String type) throws Exception {
        return service.search_id(id , doctype , type);
    }

    @GetMapping(value = "/rest/search/serielist")
    public Object search_Id(@RequestParam String startTime , @RequestParam String endTime, @RequestParam String cloumid,@RequestParam String type) throws Exception {
        return service.search_list(startTime , endTime , cloumid , type);
    }
}
