package com.liuw.management.controller.system;

import com.liuw.management.db.domain.system.User;
import com.liuw.management.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuw
 * @date 2020-05-28 23:36
 */

@Api(value = "UserController", tags = "用户管理")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "根据i查询用户信息")
    @GetMapping("/id/{id}")
    public Map<String, Object> getById(@PathVariable("id") Long id) {

        User user = null;
        try {
            user = userService.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> resp = new HashMap<>(3);
        resp.put("status", 200);
        resp.put("message", "success");
        resp.put("data", user);

        return resp;
    }
}
