package com.zb.service;

import com.zb.pojo.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 查询所有一级分类
     * @return
     */
    public List<Category> queryAllRootLevelCat();
}
