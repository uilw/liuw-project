package com.liuw.management.db.domain.system.request;

import com.liuw.management.common.request.BaseRequest;
import lombok.Data;

@Data
public class UserRequest extends BaseRequest {

    /**
     * 组织机构代码
     */
    private String orgCode;
}