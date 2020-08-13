package com.liuw.management.controller.system;

import com.liuw.management.common.controller.BaseController;
import com.liuw.management.common.response.ResponseData;
import com.liuw.management.db.domain.system.request.UserLoginRequest;
import com.liuw.management.db.domain.system.response.UserLoginResponse;
import com.liuw.management.service.system.UserLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuw
 * @date 2020-08-13 15:57
 */

@Api(value = "UserLoginController", tags = "用户登录")
@Slf4j
@RestController
@RequestMapping("/login")
public class UserLoginController extends BaseController {

    @Autowired
    private UserLoginService userLoginService;

    @ApiOperation(value = "用户登录")
    @PostMapping("/user")
    public ResponseData userLogin(@RequestBody UserLoginRequest userLoginRequest) {
        UserLoginResponse result = userLoginService.loginUser(userLoginRequest);
        return success(result);
    }

}
