package com.hubu.service;

import com.hubu.pojo.User;

public interface UserService {

    User login(String username, String password);

    User findUserByUsername(String username);

    int register(User user);

    int updatePassword(String username, String newPassword);

    User getUserInfo(String username);

    int updatePersonalInfo(User user);

    User getUserByUsernameAndPhone(String username, String phone);

    int resetPassword(User user);
}
