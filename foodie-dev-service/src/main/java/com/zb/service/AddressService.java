package com.zb.service;

import com.zb.pojo.model.UserAddress;
import com.zb.pojo.dto.AddressDTO;

import java.util.List;

public interface AddressService {

    /**
     * 根据用户id查询用户的收货地址列表
     * @param userId
     * @return
     */
    public List<UserAddress> queryAll(String userId);

    /**
     * 用户新增地址
     * @param addressDTO
     */
    public void addNewUserAddress(AddressDTO addressDTO);

    /**
     * 用户修改地址
     * @param addressDTO
     */
    public void updateUserAddress(AddressDTO addressDTO);

    /**
     * 根据用户id和地址id，删除对应的用户地址信息
     * @param userId
     * @param addressId
     */
    public void deleteUserAddress(String userId, String addressId);

    /**
     * 修改默认地址
     * @param userId
     * @param addressId
     */
    public void updateUserAddressToBeDefault(String userId, String addressId);

}
