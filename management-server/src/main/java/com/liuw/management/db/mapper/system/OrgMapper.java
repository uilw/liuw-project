package com.liuw.management.db.mapper.system;

import com.liuw.management.db.domain.system.Org;
import com.liuw.management.db.domain.system.OrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgMapper {
    long countByExample(OrgExample example);

    int deleteByExample(OrgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Org record);

    int insertSelective(Org record);

    List<Org> selectByExample(OrgExample example);

    Org selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Org record, @Param("example") OrgExample example);

    int updateByExample(@Param("record") Org record, @Param("example") OrgExample example);

    int updateByPrimaryKeySelective(Org record);

    int updateByPrimaryKey(Org record);
}