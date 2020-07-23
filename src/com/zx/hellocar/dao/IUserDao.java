package com.zx.hellocar.dao;


import com.zx.hellocar.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface IUserDao {
	/**
	 * 获取所有用户
	 * @return
	 */
	public List<User> getAllUser();
	/**
	 * 查询要登陆的用户
	 * @param name 名字
	 * @return
	 */
	public List<?> selectUser(String name);

	/**
	 * 获取要注册的用户
	 * @param obj 需要传入的占位符的值(形参)
	 * @return
	 */
	public int updateUser(Object...obj);
	
}
