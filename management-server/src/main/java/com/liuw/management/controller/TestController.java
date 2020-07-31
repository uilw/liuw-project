package com.liuw.management.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuw
 * @date 2020-05-28 23:36
 */
@Api(value = "TestController", tags = "测试")
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value = "responseTestInfo")
    @GetMapping("/info")
    public Map<String, Object> responseTestInfo() {

        log.info("into 123 ...");
        Map<String, Object> resp = new HashMap<>(3);
        resp.put("status", 200);
        resp.put("message", "success");
        resp.put("data", "");

        return resp;
    }

}
