package com.zb.service.impl.center;

import com.zb.mapper.UsersMapper;
import com.zb.pojo.model.Users;
import com.zb.service.center.CenterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhaobao1830
 * @Date 2024-02-21 09:08
 */
@Service
public class CenterUserServiceImpl implements CenterUserService {

    @Autowired
    private UsersMapper usersMapper;

    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public Users queryUserInfo(String userId) {
        Users users = usersMapper.selectById(userId);
        users.setPassword(null);
        return users;
    }
}
