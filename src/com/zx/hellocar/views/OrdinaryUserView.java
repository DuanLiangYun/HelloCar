package com.zx.hellocar.views;

import com.zx.hellocar.bean.Result;
import com.zx.hellocar.dao.UserDaoImpl;
import com.zx.hellocar.entity.User;
import com.zx.hellocar.service.impl.UserServiceImpl;
import com.zx.hellocar.utils.PrintUtil;

import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

public class OrdinaryUserView {

	public void initUserInfo(String name,String password){

		Scanner inputScanner = new Scanner(System.in);

		UserServiceImpl userService = new UserServiceImpl();
		UserDaoImpl userDao = new UserDaoImpl();

		Result<User> result = userService.userLogin(name,password);
		PrintUtil.println(result.msg);
		PrintUtil.println();
		PrintUtil.println();
		PrintUtil.println("---------------------------" + result.msg + "---------------------------");
		PrintUtil.println();
		if(result.code == 0){
			PrintUtil.println("1、查询车辆     2、订单查询");
			PrintUtil.println("请输入选择：");
			int choose = inputScanner.nextInt();
			switch (choose){
				case 1:{

					break;
				}
			}

		}else {
			PrintUtil.println("1、返回欢迎页     2、注册    3、退出");
			PrintUtil.println("请输入选择：");
			int choose = inputScanner.nextInt();
			switch (choose){
				case 1:{
					WelcomeView.welcome();
					break;
				}
				case 2:{

					break;
				}
				case 3:{
					PrintUtil.print("程序已退出，感谢使用...\n\n\n");
					System.exit(0);
					break;
				}
			}
		}
	}

}
