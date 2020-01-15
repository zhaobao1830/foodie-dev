package com.zb.service.impl;

import com.zb.dao.UsersMapper;
import com.zb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UsersMapper usersMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {
        int resultCount = usersMapper.checkUsername(username);
        if (resultCount == 0) {
            return false;
        }
        return true;
    }
}
