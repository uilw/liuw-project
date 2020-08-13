package com.liuw.management.db.domain.system.request;

import com.liuw.management.common.request.BaseRequest;
import lombok.Data;

@Data
public class UserLoginRequest extends BaseRequest {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}