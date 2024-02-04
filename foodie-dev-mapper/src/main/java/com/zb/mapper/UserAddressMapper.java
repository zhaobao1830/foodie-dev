package com.zb.mapper;

import com.zb.pojo.UserAddress;

import java.util.List;

public interface UserAddressMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserAddress record);

    int insertSelective(UserAddress record);

    UserAddress selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserAddress record);

    int updateByPrimaryKey(UserAddress record);

    List<UserAddress> selectByUserId(String userId);

    int deleteByUserIdAndaddressId(String userId, String addressId);

    List<UserAddress> select(UserAddress userAddress);
}