package com.zb.mapper;

import com.zb.pojo.ItemsSpec;

import java.util.List;

public interface ItemsSpecMapper {
    int deleteByPrimaryKey(String id);

    int insert(ItemsSpec record);

    int insertSelective(ItemsSpec record);

    ItemsSpec selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ItemsSpec record);

    int updateByPrimaryKey(ItemsSpec record);

    public List<ItemsSpec> getItemsSpec(String itemId);
}