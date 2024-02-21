package com.zb.service.impl.center;

import com.zb.mapper.UsersMapper;
import com.zb.pojo.dto.CenterUserDTO;
import com.zb.pojo.model.Users;
import com.zb.service.center.CenterUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserInfo(String userId) {
        Users users = usersMapper.selectById(userId);
        users.setPassword(null);
        return users;
    }

    /**
     * 修改用户信息
     *
     * @param userId
     * @param centerUserDTO
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users updateUserInfo(String userId, CenterUserDTO centerUserDTO) {
        Users updateUser = new Users();
        BeanUtils.copyProperties(centerUserDTO, updateUser);
        updateUser.setId(userId);
        updateUser.setUpdatedTime(new Date());
        usersMapper.updateById(updateUser);

        return queryUserInfo(userId);
    }
}
