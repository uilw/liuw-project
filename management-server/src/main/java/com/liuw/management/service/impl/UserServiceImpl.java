package com.liuw.management.service.impl;


import com.liuw.management.db.domain.system.User;
import com.liuw.management.db.mapper.system.UserMapper;
import com.liuw.management.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author liuw
 * @date 2020-05-23 3:26
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
