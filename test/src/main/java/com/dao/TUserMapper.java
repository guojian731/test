package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.model.TUser;
import com.model.TUserExample;

public interface TUserMapper {
    int countByExample(TUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
    
    TUser selectByNamePasswd(HashMap<String, String> map);
    
    List<TUser> getUserList(@Param("uname") String uname,@Param("isdel") int isdel);


    

}