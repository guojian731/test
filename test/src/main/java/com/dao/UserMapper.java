package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.TUser;
import com.model.user;


public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
    
   


    
}