package com.zb.controller;

import com.zb.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stu")
public class StuController {

    @Autowired
    private StuService stuService;

    @RequestMapping(value = "/getStu")
    public Object getStu(int id) {
        return stuService.getStuInfo(id);
    }
}
