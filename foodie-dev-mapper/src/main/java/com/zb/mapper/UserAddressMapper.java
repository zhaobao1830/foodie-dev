package com.zb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zb.pojo.model.UserAddress;

import java.util.List;

public interface UserAddressMapper extends BaseMapper<UserAddress> {
    int deleteByPrimaryKey(String id);

    int insertSelective(UserAddress record);

    UserAddress selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserAddress record);

    int updateByPrimaryKey(UserAddress record);

    int deleteByUserIdAndAddressId(String userId, String addressId);

    List<UserAddress> select(UserAddress userAddress);

    UserAddress selectOne(UserAddress userAddress);
}