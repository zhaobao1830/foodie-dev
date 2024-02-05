package com.zb.service.impl;

import com.zb.mapper.CarouselMapper;
import com.zb.pojo.model.Carousel;
import com.zb.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> queryAll(Integer isShow) {
        List<Carousel> carouselList = carouselMapper.selectAllCarousel(isShow);
        return carouselList;
    }
}
