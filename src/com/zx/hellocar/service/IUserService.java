package com.zx.hellocar.service;


import com.zx.hellocar.bean.Result;
import com.zx.hellocar.entity.User;

import java.util.List;

public interface IUserService {
	/**
	 * 用户登录
	 * @param name 名字
	 * @param password 密码
	 * @return
	 */
	public Result userLogin(String name, String password);

	/**
	 * 用户注册
	 * @param objects 传入值
	 * @return 返回受影响结果
	 */
	public int userRegistration(Object ... objects);

	/**
	 * 获取所有用户
	 * @return
	 */
	public List<User> getUsers();
}
