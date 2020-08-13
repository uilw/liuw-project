package com.liuw.management.service.system.impl;

import com.liuw.management.db.domain.system.Org;
import com.liuw.management.db.domain.system.OrgExample;
import com.liuw.management.db.domain.system.response.OrgTreeResponse;
import com.liuw.management.db.mapper.system.OrgMapper;
import com.liuw.management.service.system.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private OrgMapper orgMapper;

    @Override
    public List<OrgTreeResponse> getOrgTree() {
        List<OrgTreeResponse> responseList = new ArrayList<>();

        // 查询有效的组织机构
        OrgExample orgParentExample = new OrgExample();
        OrgExample.Criteria parentCriteria = orgParentExample.createCriteria();
        parentCriteria.andStatusEqualTo("1");
        List<Org> orgList = orgMapper.selectByExample(orgParentExample);

        // 添加父节点
        orgList.stream().forEach(e -> {
            if (0 == e.getParentId()) {
                OrgTreeResponse orgTree = new OrgTreeResponse();
                orgTree.setId(e.getId());
                orgTree.setName(e.getName());
                orgTree.setCode(e.getCode());
                responseList.add(orgTree);
            }
        });

        // 递归添加子组织机构
        responseList.stream().forEach(e -> {
            e.setChildren(getChildTree(e.getId(), orgList));
        });

        return responseList;
    }

    // 递归子机构
    private List<OrgTreeResponse> getChildTree(Integer parentId, List<Org> orgList) {

        List<OrgTreeResponse> children = new ArrayList<>();

        orgList.stream().forEach(e -> {
            OrgTreeResponse orgTree = new OrgTreeResponse();
            if (null != e.getParentId() && e.getParentId() == parentId) {
                orgTree.setId(e.getId());
                orgTree.setName(e.getName());
                orgTree.setCode(e.getCode());
                children.add(orgTree);
            }
        });

        // 递归子机构
        children.stream().forEach(e -> {
            e.setChildren(getChildTree(e.getId(), orgList));
        });

        // 递归退出条件
        if (children.size() == 0) {
            return null;
        }

        return children;
    }
}
