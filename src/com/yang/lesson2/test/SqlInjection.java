package com.yang.lesson2.test;

import com.yang.lesson2.untils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInjection {
    public static void main(String[] args) throws SQLException {
//        login("韩信","123456");
        login("'or '1=1 ","123456");

    }
    //登录业务
    public static void login(String username,String password) throws SQLException {
        Connection coon = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            coon = JdbcUtils.getConnection();
            st = coon.createStatement();
            String sql = "select * from users where name = '"+username +"'" +"and password = '"+password +"'";
            rs = st.executeQuery(sql);
            while (rs.next()){
                System.out.println("name=" +rs.getString("name"));
                System.out.println("password=" +rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(coon,st,rs);
        }


    }
}
