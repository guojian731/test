package com.dao;

import com.model.TMenu;
import com.model.TMenuExample;

public interface TMenuMapper {
    int countByExample(TMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TMenu record);

    int insertSelective(TMenu record);

    TMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TMenu record);

    int updateByPrimaryKey(TMenu record);
}