package com.zb.dao;

import com.zb.pojo.Carousel;

public interface CarouselMapper {
    int deleteByPrimaryKey(String id);

    int insert(Carousel record);

    int insertSelective(Carousel record);

    Carousel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Carousel record);

    int updateByPrimaryKey(Carousel record);
}