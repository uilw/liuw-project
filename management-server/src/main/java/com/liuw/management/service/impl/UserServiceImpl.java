package com.liuw.management.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuw.management.db.domain.system.User;
import com.liuw.management.db.domain.system.UserExample;
import com.liuw.management.db.domain.system.request.UserRequest;
import com.liuw.management.db.mapper.system.UserMapper;
import com.liuw.management.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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

    @Override
    public PageInfo<User> findByPage(@RequestBody UserRequest userRequest) {
        PageHelper.startPage(1,10);
        List<User> users = userMapper.selectByExample(new UserExample());
        return new PageInfo<User>(users);
    }
}
