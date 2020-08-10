package com.zb.service.impl;

import com.zb.mapper.UserAddressMapper;
import com.zb.pojo.UserAddress;
import com.zb.pojo.bo.AddressBO;
import com.zb.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public List<UserAddress> queryAll(String userId) {
        return userAddressMapper.selectByUserId(userId);
    }

    @Override
    public void addNewUserAddress(AddressBO addressBO) {

    }
}
