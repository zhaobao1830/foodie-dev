package com.zb.service;

import com.zb.pojo.Carousel;

import java.util.List;

public interface CarouselService {

    /**
     * 查询所有轮播图列表
     * @param isShow 是否显示
     * @return carouselList
     */
    public List<Carousel> queryAll(Integer isShow);
}
