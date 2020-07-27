package com.zb.service.impl;

import com.zb.dao.CategoryMapper;
import com.zb.pojo.Category;
import com.zb.pojo.vo.CategoryVO;
import com.zb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryAllRootLevelCat() {
        List<Category> categoryList = categoryMapper.selectAllCategory(1);
        return categoryList;
    }

    @Override
    public List<CategoryVO> getSubCatList(Integer rootCatId) {
        List<CategoryVO> categoryVOList = categoryMapper.getSubCatList(rootCatId);
        return categoryVOList;
    }
}
