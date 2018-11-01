package com.dcits.szsqwfw.dao;

import java.util.List;

import com.dcits.szsqwfw.model.User;
/***
 * Dao
 * @author 任亮
 *
 */
public interface UserDao {
	/***
	 * 根据id查询用户
	 * @param userId
	 * @return
	 */
	public User findUserById(int userId); 
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> findAllUsers();
	/**
	 * 查询用户总数
	 * @return
	 */
	public int getUserCount();
	/***
	 * 查询姓名模糊匹配的用户的数量
	 * @return
	 */
	public int getSomeUserCount(String name);
	/**
	 * 更新某个id的用户的姓名
	 * @param id
	 * @param name
	 * @return
	 */
	public void updateUser(User user);
	/***
	 * 保存用户
	 * @param user
	 */
	public void saveUser(User user);
	/***
	 * 删除用户
	 * @param user
	 */
	public void deleteUser(User user);
	
}
