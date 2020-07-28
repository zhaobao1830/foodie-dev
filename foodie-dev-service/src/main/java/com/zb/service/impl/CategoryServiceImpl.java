package com.zb.service.impl;

import com.zb.dao.CategoryMapper;
import com.zb.pojo.Category;
import com.zb.pojo.vo.CategoryVO;
import com.zb.pojo.vo.NewItemsVO;
import com.zb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Category> queryAllRootLevelCat() {
        List<Category> categoryList = categoryMapper.selectAllCategory(1);
        return categoryList;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<CategoryVO> getSubCatList(Integer rootCatId) {
        List<CategoryVO> categoryVOList = categoryMapper.getSubCatList(rootCatId);
        return categoryVOList;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId) {
        Map<String, Object> map = new HashMap<>();
        map.put("rootCatId", rootCatId);

        return categoryMapper.getSixNewItemsLazy(map);
    }
}
