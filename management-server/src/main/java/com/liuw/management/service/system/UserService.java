package com.liuw.management.service.system;


import com.github.pagehelper.PageInfo;
import com.liuw.management.db.domain.system.User;
import com.liuw.management.db.domain.system.request.UserRequest;

/**
 * @author liuw
 * @date 2020-05-28 23:37
 */
public interface UserService {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    User getById(Long id);

    /**
     * 分页查询
     */
    PageInfo<User> findByPage(UserRequest userRequest);

    /**
     * 修改
     */
    int update(User user);

}
