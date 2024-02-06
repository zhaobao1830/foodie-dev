package com.zb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zb.pojo.model.Carousel;

import java.util.List;

public interface CarouselMapper extends BaseMapper<Carousel> {
    int deleteByPrimaryKey(String id);

    int insert(Carousel record);

    int insertSelective(Carousel record);

    Carousel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Carousel record);

    int updateByPrimaryKey(Carousel record);

    List<Carousel> selectAllCarousel(Integer isShow);
}