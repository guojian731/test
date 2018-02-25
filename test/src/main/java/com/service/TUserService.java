package com.service;

import java.util.HashMap;
import java.util.List;

import com.model.TUser;
import com.model.TUserExample;
import com.model.user;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;


public interface TUserService {
	
	 	int countByExample(TUserExample example);

	    int deleteByPrimaryKey(Long id);

	    int insert(TUser record);

	    int insertSelective(TUser record);

	    TUser selectByPrimaryKey(Long id);

	    int updateByPrimaryKeySelective(TUser record);

	    int updateByPrimaryKey(TUser record);
	    
	    TUser selectByNamePasswd(HashMap<String, String> map);

	    List<TUser> getUserList(String name,Integer isdel);
}
