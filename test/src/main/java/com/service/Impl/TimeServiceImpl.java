package com.service.Impl;

import org.springframework.web.servlet.ModelAndView;

import com.model.user;
import com.service.TimeService;
import com.service.UserService;

public class TimeServiceImpl implements TimeService{

	@Override
	public Object qian() {
		System.out.println("qian");
		return "redirect:/sys/getOtherList.htm";
	}

	@Override
	public void hou() {
		System.out.println("hou");
	}

	

}
