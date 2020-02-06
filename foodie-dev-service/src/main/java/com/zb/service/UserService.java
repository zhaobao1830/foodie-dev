package com.zb.service;

import com.zb.pojo.Users;
import com.zb.pojo.bo.UserBO;
import org.springframework.stereotype.Service;

public interface UserService {

    /**
     * 判断用户是否存在
     */
    public boolean queryUsernameIsExist(String username);

    /**
     * 创建用户
     */
    // 只要是前端传给后端的list或object都可以称为BO
    public Users createUser(UserBO userBO);
}
