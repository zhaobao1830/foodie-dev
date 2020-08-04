package com.zb.dao;

import com.zb.pojo.ItemsComments;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ItemsCommentsMapper {
    int deleteByPrimaryKey(String id);

    int insert(ItemsComments record);

    int insertSelective(ItemsComments record);

    ItemsComments selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ItemsComments record);

    int updateByPrimaryKey(ItemsComments record);

    int selectCount(@Param("paramsMap") Map<String, Object> map);
}