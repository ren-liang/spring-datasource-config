package com.dcits.dao;

import java.util.List;

import com.dcits.model.User;
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
	public List<?> findUsers(final String HQL);
	public void addUsers(Object object);
	public void updateUsers(Object object);
	public void deleteUsers(Object object);
	
}
