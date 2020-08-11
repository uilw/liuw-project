package com.liuw.management.service.impl;

import com.liuw.management.db.domain.system.User;
import com.liuw.management.service.TestService;
import com.liuw.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public void testTransaction() {
        // 数据库查询
        User user = userService.getById(1L);

        // 更新remark
        user.setRemark(new Date().toString());
        user.setUpdateTime(new Date());
        userService.update(user);
        
        user.setRemark("exception update");
        user.setUpdateTime(new Date());
        //int a = 1/0;
        userService.update(user);

    }

}
