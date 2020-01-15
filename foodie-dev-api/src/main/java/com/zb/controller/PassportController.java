package com.zb.controller;

import com.zb.service.UserService;
import com.zb.utils.IMOOCJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
