package com.zb.service;

import org.springframework.stereotype.Service;

public interface UserService {

    public boolean queryUsernameIsExist(String username);
}
