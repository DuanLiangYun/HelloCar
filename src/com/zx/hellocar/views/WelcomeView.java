package com.zx.hellocar.views;


import com.zx.hellocar.utils.PrintUtil;

import java.util.Scanner;

public class WelcomeView {
    public static void main(String[] args) {
        welcome();
    }

    public static void welcome(){

        PrintUtil.print("\n\n");
        PrintUtil.println("---------------------------哈喽租车系统欢迎您---------------------------\n");
        PrintUtil.println("1、普通用户登录    2、管理员登录    3、注册    4、退出");

        PrintUtil.print("\n\n");
        PrintUtil.print("请输入选择：");

        Scanner inputScanner = new Scanner(System.in);
        int choose = inputScanner.nextInt();

        switch (choose){
            case 1:{
                PrintUtil.print("请输入用户名：");
                String userName = inputScanner.next();
                PrintUtil.print("请输入密码：");
                String userPassword = inputScanner.next();

                OrdinaryUserView ordinaryUserView = new OrdinaryUserView();
                ordinaryUserView.initUserInfo(userName,userPassword);

                break;
            }
            case 2:{
                PrintUtil.print("请输入管理员名称：");

                break;
            }
            case 3:{
                PrintUtil.print("注册：");

                break;
            }
            case 4:{
                PrintUtil.print("程序已退出，感谢使用...\n\n\n");
                System.exit(0);
                break;
            }
        }
    }
}
