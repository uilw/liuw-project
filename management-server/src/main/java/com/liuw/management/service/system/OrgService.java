package com.liuw.management.service.system;


import com.liuw.management.db.domain.system.response.OrgTreeResponse;

import java.util.List;

/**
 * @author liuw
 * @date 2020-08-13 10:49
 */
public interface OrgService {

    /**
     * 查询组织机构树
     */
    List<OrgTreeResponse> getOrgTree();
}
