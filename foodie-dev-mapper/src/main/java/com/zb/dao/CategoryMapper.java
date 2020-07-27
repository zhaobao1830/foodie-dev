package com.zb.dao;

import com.zb.pojo.Carousel;
import com.zb.pojo.Category;
import com.zb.pojo.vo.CategoryVO;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> selectAllCategory(Integer type);

    public List<CategoryVO> getSubCatList(Integer rootCatId);
}