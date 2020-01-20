package com.zb.controller;

import com.zb.pojo.bo.UserBO;
import com.zb.service.UserService;
import com.zb.utils.IMOOCJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/passport")
public class PassportController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/usernameIsExist", method = RequestMethod.GET)
    public IMOOCJSONResult usernameIsExist(@RequestParam("username") String username) {

        // 1、判断用户名不能为空
        if (StringUtils.isBlank(username)) {
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }

        // 2、查找注册的用户名是否存在

        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return IMOOCJSONResult.errorMsg("用户名已经存在");
        }
        return IMOOCJSONResult.ok();
    }

    @PostMapping("/regist")
    public IMOOCJSONResult regist(@RequestBody UserBO userBO) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();
        // 0、判断用户名和密码不能为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password) ||
                StringUtils.isBlank(confirmPassword)) {
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }
        // 1、查询用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return IMOOCJSONResult.errorMsg("用户名已经存在");
        }
        // 2、密码长度不能少于6次
        if (password.length() < 6) {
            return IMOOCJSONResult.errorMsg("密码长度不能小于6");
        }
        // 3、判断俩次密码是否一致
        if (!password.equals(confirmPassword)) {
            return IMOOCJSONResult.errorMsg("俩次密码输入不一致");
        }
        // 4、实现注册
        userService.createUser(userBO);

        return IMOOCJSONResult.ok();
    }
}
