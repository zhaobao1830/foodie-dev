package com.zb.service.impl;

import com.zb.dao.StuMapper;
import com.zb.dao.UserMapper;
import com.zb.pojo.Stu;
import com.zb.pojo.User;
import com.zb.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public User getStuInfo(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
