package com.dao;

import com.model.TMarine;
import com.model.TMarineExample;

public interface TMarineMapper {
    int countByExample(TMarineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TMarine record);

    int insertSelective(TMarine record);

    TMarine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TMarine record);

    int updateByPrimaryKey(TMarine record);
}