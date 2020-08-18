package com.liuw.management.db.domain.system.request;

import com.liuw.management.common.request.BaseRequest;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class UserLoginRequest extends BaseRequest {

    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空！")
    private String username;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为null！")
//    @NotEmpty(message = "密码不能为empty！")
//    @NotBlank(message = "密码不能为blank！")
    @Length(min = 6, message = "密码长度不小于6!")
    private String password;

}