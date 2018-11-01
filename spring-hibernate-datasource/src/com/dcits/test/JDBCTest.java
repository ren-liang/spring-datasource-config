package com.dcits.test;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dcits.dao.UserDao;
import com.dcits.model.User;

//方式一 使用Spring test初始化Spring容器
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ApplicationContext.xml")//加载ApplicationContext.xml文件
public class JDBCTest {
	//方式二 使用Junit@Before
/*	private UserDao userDao;
	private BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	@Before
	public void getUserDao(){
		userDao = factory.getBean("userDao", UserDao.class);
	}*/
	@Resource(name="userDao")
	private UserDao userDao;

}
