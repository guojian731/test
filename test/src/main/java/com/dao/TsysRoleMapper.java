package com.dao;

import com.model.TsysRole;
import com.model.TsysRoleExample;

public interface TsysRoleMapper {
    int countByExample(TsysRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TsysRole record);

    int insertSelective(TsysRole record);

    TsysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TsysRole record);

    int updateByPrimaryKeyWithBLOBs(TsysRole record);

    int updateByPrimaryKey(TsysRole record);
}