package com.zb.controller;

import com.zb.common.ServerResponseJsonResult;
import com.zb.enums.YesOrNo;
import com.zb.pojo.Carousel;
import com.zb.service.CarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zhaobao1830
 * @Date: 2021/4/1 14:16
 */
@Api(value = "首页", tags = {"首页相关接口"}, consumes = "application/json")
@RestController
@RequestMapping("index/")
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
    @RequestMapping(value = "carousel", method = RequestMethod.GET)
    public ServerResponseJsonResult carousel() {
        List<Carousel> carouselList = carouselService.queryAll(YesOrNo.YES.type);
        return ServerResponseJsonResult.ok(carouselList);
    }
}
