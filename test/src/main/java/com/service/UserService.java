package com.service;

import com.model.user;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;


public interface UserService {
	
	user getUserById(Integer id);

    
}
