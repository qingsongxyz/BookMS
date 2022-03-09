package com.hubu.service.impl;

import com.hubu.mapper.UserMapper;
import com.hubu.pojo.User;
import com.hubu.service.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userMapper.selectOne(user);
    }

    @Override
    public User findUserByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        return userMapper.selectByPrimaryKey(user);
    }

    @Override
    public int register(User user) {
        user.setRole("customer");
        return userMapper.insert(user);
    }

    @Override
    public int updatePassword(String username, String newPassword) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(newPassword);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User getUserInfo(String username) {
        return userMapper.selectByPrimaryKey(username);
    }

    @Override
    public int updatePersonalInfo(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User getUserByUsernameAndPhone(String username, String phone) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username).andEqualTo("phone", phone);
        return userMapper.selectOneByExample(example);
    }

    @Override
    public int resetPassword(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
