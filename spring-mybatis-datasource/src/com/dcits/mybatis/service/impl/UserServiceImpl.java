package com.dcits.mybatis.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dcits.mybatis.dao.IUserDao;
import com.dcits.mybatis.model.User;
import com.dcits.mybatis.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}

}
