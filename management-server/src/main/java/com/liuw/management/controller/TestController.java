package com.liuw.management.controller;

import com.liuw.management.common.controller.BaseController;
import com.liuw.management.common.response.ResponseData;
import com.liuw.management.service.system.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuw
 * @date 2020-05-28 23:36
 */

@Api(value = "TestController", tags = "测试")
@Slf4j
@RestController
public class TestController extends BaseController {

    @Autowired
    private TestService testService;

    @ApiOperation(value = "修改用户信息")
    @GetMapping("/test/transaction")
    public ResponseData transactionTest() {
        testService.testTransaction();
        return success();
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/vue-admin-template/user/login")
    public ResponseData userLogin() {
        return success();
    }
    
}
