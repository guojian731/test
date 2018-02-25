package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.user;
import com.service.UserService;



@Controller  
public class UserController {
		
		@Autowired
		private UserService userService;
	      
	    @RequestMapping(value="/getOtherList.htm",produces="text/html;charset=UTF-8" )   
	    public String getOtherList(){  
	      user user1=  userService.getUserById(1);
	      System.out.println(user1.getName());
	      return "test/test";
	    } 
	    
	    @RequestMapping(value="sys/getOtherList.htm",produces="text/html;charset=UTF-8" )   
	    public String denglu(){  
	      return "test/test1";
	    } 
}
