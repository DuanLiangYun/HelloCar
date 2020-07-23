package com.zx.hellocar.dao;


import com.zx.hellocar.entity.User;
import com.zx.hellocar.utils.JDBCUtil;
import com.zx.hellocar.utils.SQLUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements IUserDao {

    /**
     * 查询要登陆的用户
     *
     * @param name 名字
     * @return
     */
    @Override
    public List<User> selectUser(String name) {
        Connection conn = JDBCUtil.getConn();
        String sql = "select * from user where username=?";
        List<User> list = (List<User>) SQLUtil.exceQuery(sql, name);
        return list;
    }

    /**
     * 获取全部用户
     */
    @Override
    public List<User> getAllUser() {
        String sql = "select * from user";
        List<User> users = new ArrayList<>();
        List<Map> list = (List<Map>) SQLUtil.exceQuery(sql);

        for (int i = 0; i < list.size(); i++) {
            Map item = (Map) list.get(i);
            User user = new User();
            user.setId((Integer) item.get("id"));
            user.setName((String) item.get("username"));
            user.setPassword((String) item.get("password"));
            user.setSex((String) item.get("sex"));
            user.setId_number((String) item.get("id_number"));
            user.setTel((String) item.get("tel"));
            user.setAddress((String) item.get("address"));
            user.setType((Integer) item.get("type"));
            users.add(user);

        }
        return users;
    }

    public User getQuery(ResultSet rSet) {
        User user = null;
        try {
            new User(rSet.getInt("id"), rSet.getString("username"),
                    rSet.getString("password"), rSet.getString("sex"),
                    rSet.getString("id_number"), rSet.getString("tel"),
                    rSet.getString("address"), rSet.getInt("type")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 注册用户
     * 将信息插入记录表
     */
    @Override
    public int updateUser(Object... obj) {
        for (Object object : obj) {
            System.out.println(object);
        }
        Connection conn = JDBCUtil.getConn();
        String sql =
                "insert into user(username,password,sex,id_number,tel,address,type)values(?,?,?,?,?,?,?))";
        int insert = SQLUtil.exceUpdate(sql, obj);
        return insert;
    }

}//end of UserDaoImpl
