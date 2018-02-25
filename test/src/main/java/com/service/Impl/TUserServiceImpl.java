package com.service.Impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TUserMapper;
import com.dao.UserMapper;
import com.model.TUser;
import com.model.TUserExample;
import com.model.user;
import com.service.TUserService;
import com.service.UserService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;


@Service
public class TUserServiceImpl implements TUserService{
	
	@Autowired
	private TUserMapper tusermapper;
	
	@Override
	public int countByExample(TUserExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TUser selectByPrimaryKey(Long id) {
		System.out.println(id);
		TUser user=tusermapper.selectByPrimaryKey(id);
		return user;
	}

	@Override
	public int updateByPrimaryKeySelective(TUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TUser selectByNamePasswd(HashMap<String, String> map) {
		TUser user=tusermapper.selectByNamePasswd(map);
		return user;
	}

	@Override
	public List<TUser> getUserList(String name, Integer isdel) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

}
