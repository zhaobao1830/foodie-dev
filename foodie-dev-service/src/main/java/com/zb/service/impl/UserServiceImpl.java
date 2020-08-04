package com.zb.service.impl;

import com.zb.mapper.UsersMapper;
import com.zb.enums.Sex;
import com.zb.pojo.Users;
import com.zb.pojo.bo.UserBO;
import com.zb.service.UserService;
import com.zb.utils.DateUtil;
import com.zb.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    private static final String USER_FACE = "http://tupian.baike.com/ipad/a0_78_52_01200000123847134434529793168_jpg.html";

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {
        int resultCount = usersMapper.checkUsername(username);
        if (resultCount == 0) {
            return false;
        }
        return true;
    }

    // @Transactional(propagation = Propagation.REQUIRED) 出错以后可以回滚
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO userBO) {
        String userId = sid.nextShort();
         Users user = new Users();
        user.setId(userId);
        user.setUsername(userBO.getUsername());
        try {
            user.setPassword(MD5Utils.MD5EncodeUtf8(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 默认用户昵称等同于用户名
        user.setNickname(userBO.getUsername());
        // 默认头像
        user.setFace(USER_FACE);
        // 默认生日
        user.setBirthday(DateUtil.stringToDate("1900-01-01"));
        // 默认性别为保密
        user.setSex(Sex.secret.type);

        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());

        usersMapper.insert(user);

        return user;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserForLogin(String username, String password) {
        //todo 密码登陆MD5
        String md5Password = MD5Utils.MD5EncodeUtf8(password);
        Users user = usersMapper.selectLogin(username, md5Password);
        if (user == null) {
            return null;
        }
        return user;
    }
}
