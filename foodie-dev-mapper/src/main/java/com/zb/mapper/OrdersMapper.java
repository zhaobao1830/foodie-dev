package com.zb.mapper;

import com.zb.pojo.model.Orders;

public interface OrdersMapper {
    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    // 项目里的selectOne都有问题
    Orders selectOne(Orders orders);
}