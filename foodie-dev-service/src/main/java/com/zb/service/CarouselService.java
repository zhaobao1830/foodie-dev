package com.zb.service;

import com.zb.pojo.Carousel;

import java.util.List;

/**
 * @Author: zhaobao1830
 * @Date: 2021/4/1 15:32
 */
public interface CarouselService {

    /**
     * 查询所有轮播图列表
     * @param isShow
     * @return
     */
     public List<Carousel> queryAll(Integer isShow);
}
