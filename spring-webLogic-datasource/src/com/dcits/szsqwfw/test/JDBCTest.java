package com.dcits.szsqwfw.test;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dcits.szsqwfw.dao.UserDao;
import com.dcits.szsqwfw.model.User;

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
	@Test
	public void testfindUserById() {
		User u = userDao.findUserById(2);
		System.out.println(u.getName());
	}
	@Test
	public void findAllUsers(){
		List<User> list = userDao.findAllUsers();
		for(User u:list){
			System.out.println("姓名："+u.getName()+"密码："+u.getPassword());
		}
	}
	@Test
	public void getSomeUserCount(){
		int count = userDao.getSomeUserCount("zhang");
		System.out.println("用户姓名为zhang的用户数："+count);
	}
	@Test
	public void  updateUser(){
		User u = new User();
		u.setId(2);
		u.setName("lisi");
		userDao.updateUser(u);
		System.out.println("更新用户");
	}
	@Test
	public void  saveUser(){
		User u = new User();
		u.setName("wangwu");
		u.setPassword("00000");
		userDao.saveUser(u);
		System.out.println("保存用户");
	}
	
	@Test
	public void  deleteUser(){
		User u = new User();
		u.setId(3);
		userDao.deleteUser(u);
		System.out.println("删除用户");
	}
}
