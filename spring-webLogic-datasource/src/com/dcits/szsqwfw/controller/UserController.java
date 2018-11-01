package com.dcits.szsqwfw.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dcits.szsqwfw.dao.UserDao;

@Controller
public class UserController {
	private UserDao userDao;
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@RequestMapping("/adduser/{id}")
	// ,@PathVariable int id,ModelMap model
	public String addUser(HttpServletRequest request, ModelMap model,@PathVariable int id) {
		String result = "this is addUser------优化版"+id;
		int count=userDao.getUserCount();
		model.addAttribute("result", result+count);
		// request.setAttribute("result", result);
		System.out.println(result);
		return "welcome";
	}

	@RequestMapping("/deluser")
	public String delUser(HttpServletRequest request, ModelMap model) {
		String result = "this is delUser------优化版";
		System.out.println(result);
		request.setAttribute("result", result);
		return "index";
	}
}
