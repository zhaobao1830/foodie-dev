package com.zb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
        QueryWrapper<Carousel> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Carousel::getIsShow, isShow).orderByDesc(Carousel::getCreateTime);
        return carouselMapper.selectList(wrapper);
    }
}
