package com.liuw.management.service.system.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuw.management.db.domain.system.User;
import com.liuw.management.db.domain.system.UserExample;
import com.liuw.management.db.domain.system.request.UserRequest;
import com.liuw.management.db.mapper.system.UserMapper;
import com.liuw.management.service.system.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author liuw
 * @date 2020-05-23 3:26
 */
@Service
@CacheConfig(cacheNames = "USER")
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Cacheable(key = "#id")
    public User getById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<User> findByPage(@RequestBody UserRequest userRequest) {
        // 设置分页
        PageHelper.startPage(userRequest.getPage(), userRequest.getPageSize());
        
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        // 组织机构代码
        if(StringUtils.isNotBlank(userRequest.getOrgCode())) {
            criteria.andOrgCodeEqualTo(userRequest.getOrgCode());
        }
        
        List<User> users = userMapper.selectByExample(example);

        return new PageInfo<User>(users);
    }

    @Override
    @CacheEvict(key = "#user.id")
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }
}
