package com.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.TUserMapper;
import com.model.TUser;
import com.service.TUserService;

@Controller
public class SystemController {
	
	@Autowired
	private TUserService tuserService;
	
	
	
	@RequestMapping(value="system/yzlogin.htm")
	public String yanzhengdenglu(HttpServletRequest request,HttpServletResponse reponse,ModelMap map){
		//HashMap<String,String> map1=new HashMap<String,String>();
				//map1.put("uname", "admin");
				//map1.put("upass", "admin");
				//TUser user = tuserService.selectByNamePasswd(map1);
				//System.out.println(user.getDept());
				//TUser user = tuserService.selectByPrimaryKey(Long.valueOf(11));
				//System.out.println(user.getAge());
				System.out.println("ss");
		return null;
	}
	@RequestMapping("/system/go_login.htm")
	public String gologin(HttpServletRequest request, HttpServletResponse response, ModelMap map) throws Exception {
		System.out.println("进来了");
		return "include/login";
	}
	@RequestMapping("system/do_login.htm")
	public String dologin(HttpServletRequest request, HttpServletResponse response, ModelMap map) throws Exception {
		
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("uname", request.getParameter("uname"));
		map1.put("upass", request.getParameter("upass"));
		TUser user = tuserService.selectByNamePasswd(map1);
		String a = "";
		int b = 9;
		request.getSession();
		if (user!=null) {
			return "/index";
		} else {

		}
		return null;
		
	}
}
