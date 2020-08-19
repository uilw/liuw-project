package com.liuw.management.db.domain.system.request;

import com.liuw.management.common.request.BaseRequest;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
public class UserLoginRequest extends BaseRequest {

    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为null！")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空字符串！")
//    @NotEmpty(message = "密码不能为empty！")
//    @NotBlank(message = "密码不能为blank！")
    private String password;

}