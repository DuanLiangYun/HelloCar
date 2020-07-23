package com.zx.hellocar.service.impl;


import com.zx.hellocar.bean.Result;
import com.zx.hellocar.dao.IUserDao;
import com.zx.hellocar.dao.UserDaoImpl;
import com.zx.hellocar.entity.User;
import com.zx.hellocar.service.IUserService;
import com.zx.hellocar.utils.PrintUtil;
import com.zx.hellocar.utils.SQLUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户登录注册实现类
 * @author Administrator
 */
public class UserServiceImpl implements IUserService {

	IUserDao userDao = new UserDaoImpl();

	/**
	 * 获取所有用户
	 */
	@Override
	public List<User> getUsers() {
		return userDao.getAllUser();
	}
	/**
	 * 用户登录
	 */
	public Result<User> userLogin(String name, String password) {
		List<User> users = getUsers();

		Result<User> result= new Result<>();
		result.msg = "用户不存在";

		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if (name.equals(user.getName())){
				if(password.equals(user.getPassword())){
					result.code = 0;
					result.msg = "登录成功";
					result.data = user;

					break;
				}else {
					result.code = 999;
					result.msg = "密码错误";
				}
			}
		}
		return result;

	}
	/**
	 * 注册用户以和判断用户是否存在
	 */
	@Override
	public int userRegistration(Object... objects) {		
		return userDao.updateUser(objects);
	}

	

}//end of class UserServiceImpl
