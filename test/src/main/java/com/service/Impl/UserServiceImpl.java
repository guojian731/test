package com.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserMapper;
import com.model.user;
import com.service.UserService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public user getUserById(Integer id) {
		if (id!=null) {
			user user1=userMapper.selectByPrimaryKey(id);
			System.out.println("sss");
			return user1;
		}
		return null;
	}
	

}
