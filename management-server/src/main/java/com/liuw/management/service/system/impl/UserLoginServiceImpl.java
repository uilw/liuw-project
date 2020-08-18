package com.liuw.management.service.system.impl;

import com.liuw.management.common.exception.BusinessException;
import com.liuw.management.db.domain.system.User;
import com.liuw.management.db.domain.system.UserExample;
import com.liuw.management.db.domain.system.request.UserLoginRequest;
import com.liuw.management.db.domain.system.response.UserLoginResponse;
import com.liuw.management.db.mapper.system.UserMapper;
import com.liuw.management.service.system.UserLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserLoginResponse loginUser(UserLoginRequest userLoginRequest) {
        // 根据用户名查询用户
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userLoginRequest.getUsername());
        List<User> userList = userMapper.selectByExample(example);
        // 用户存在则返回用户信息，否则返回null
        if (null != userList && userList.size() == 1 && userLoginRequest.getPassword().equals(userList.get(0).getPassword())) {
            UserLoginResponse result = new UserLoginResponse();
            result.setUsername(userList.get(0).getUsername());
            result.setToken("TOKEN918364739887276363");
            return result;
        } else {
            throw new BusinessException("用户名或密码错误！");
        }
    }
}
