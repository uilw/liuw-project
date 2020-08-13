package com.liuw.management.db.domain.system.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 组织机构树
 */
@Data
@NoArgsConstructor
public class OrgTreeResponse implements Serializable {
    
    private static final long serialVersionUID = 1230683754063981977L;

    /**
     * 组织机构id
     */
    private Integer id;

    /**
     * 组织机构名称
     */
    private String name;

    /**
     * 组织机构代码
     */
    private String code;

    /**
     * 子节点
     */
    private List<OrgTreeResponse> children;
}
