package com.zb.dao;

import com.zb.pojo.ItemsSpec;

public interface ItemsSpecMapper {
    int deleteByPrimaryKey(String id);

    int insert(ItemsSpec record);

    int insertSelective(ItemsSpec record);

    ItemsSpec selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ItemsSpec record);

    int updateByPrimaryKey(ItemsSpec record);
}