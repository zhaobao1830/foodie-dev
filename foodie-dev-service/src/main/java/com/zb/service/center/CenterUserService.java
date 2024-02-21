package com.zb.service.center;

import com.zb.pojo.model.Users;

/**
 * @Author zhaobao1830
 * @Date 2024-02-21 09:06
 */
public interface CenterUserService {

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    Users queryUserInfo(String userId);
}
