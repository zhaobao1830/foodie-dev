package com.zb.controller;

import com.zb.pojo.Users;
import com.zb.pojo.bo.UserBO;
import com.zb.service.UserService;
import com.zb.utils.CookieUtils;
import com.zb.utils.IMOOCJSONResult;
import com.zb.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/passport")
public class PassportController {

    @Autowired
    public UserService userService;

    // 判断用户名存在
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

    // 用户注册
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public IMOOCJSONResult regist(@RequestBody UserBO userBO) {

        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();

        // 0、判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
            StringUtils.isBlank(password) ||
            StringUtils.isBlank(confirmPwd)) {
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }

        // 1、查询用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return IMOOCJSONResult.errorMsg("用户名已经存在");
        }
        // 2、密码长度不能小于6位
        if (password.length() < 6) {
            return IMOOCJSONResult.errorMsg("密码长度不能小于6");
        }
        // 3、判断俩次密码是否一致
        if (!password.equals(confirmPwd)) {
            return IMOOCJSONResult.errorMsg("俩次密码不一致");
        }
        // 4、实现注册
        userService.createUser(userBO);

        return IMOOCJSONResult.ok();
    }

    // 用户登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public IMOOCJSONResult login(@RequestBody UserBO userBO,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();

        // 0、判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password)) {
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }

        Users user = userService.queryUserForLogin(username, password);
        if (user == null) {
            return IMOOCJSONResult.errorMsg("用户名和密码不匹配");
        }

        user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);

        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(user), true);

        return IMOOCJSONResult.ok(user);
    }
}
