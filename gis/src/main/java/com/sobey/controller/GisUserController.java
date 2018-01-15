package com.sobey.controller;

import com.sobey.model.GisUesr;
import com.sobey.service.IGisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest")
public class GisUserController {

    @Autowired
    private IGisUserService gisUserService;

    @GetMapping(value = "/gis/getReports")
    public Object getReports() throws Exception{
        return gisUserService.getReports();
    }

    @PostMapping(value = "/gis/update/location")
    public Object updateLocation(@RequestBody GisUesr user) throws Exception{
        return gisUserService.insertReport(user);
    }
}
