package com.zb.dao;

import com.zb.pojo.ItemsImg;
import com.zb.pojo.ItemsSpec;

import java.util.List;

public interface ItemsImgMapper {
    int deleteByPrimaryKey(String id);

    int insert(ItemsImg record);

    int insertSelective(ItemsImg record);

    ItemsImg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ItemsImg record);

    int updateByPrimaryKey(ItemsImg record);

    public List<ItemsImg> getItemsImg(String itemId);
}