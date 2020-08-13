package com.liuw.management.service.system;


import com.liuw.management.db.domain.system.request.UserLoginRequest;
import com.liuw.management.db.domain.system.response.UserLoginResponse;

/**
 * @author liuw
 * @date 2020-08-13
 */
public interface UserLoginService {

    /**
     * 用户登录
     *
     * @param userLoginRequest
     * @return
     */
    UserLoginResponse loginUser(UserLoginRequest userLoginRequest);

}
