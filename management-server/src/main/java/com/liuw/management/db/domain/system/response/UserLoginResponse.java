package com.liuw.management.db.domain.system.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserLoginResponse implements Serializable {

    private static final long serialVersionUID = -2481712416880317031L;
    
    /**
     * 用户名
     */
    private String username;

    /**
     * token
     */
    private String token;
}