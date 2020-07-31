package com.liuw.management.service;


import com.liuw.management.db.domain.system.User;

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

}
