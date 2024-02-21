package com.zb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zb.pojo.model.Users;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper extends BaseMapper<Users> {

    int checkUsername(String name);

    Users selectLogin(@Param("username") String username, @Param("password") String password);
}