package com.zb.service;

import com.zb.pojo.model.Users;
import com.zb.pojo.dto.UserDTO;

public interface UserService {

    /**
     * 判断用户是否存在
     */
    public boolean queryUsernameIsExist(String username);

    /**
     * 创建用户
     */
    // 只要是前端传给后端的list或object都可以称为BO
    public Users createUser(UserDTO userDTO);

    // 检索用户名和密码是否匹配，用于登录
    public Users queryUserForLogin(String username, String password);
}
