package com.yang.lesson3;

import com.yang.lesson2.untils.JdbcUtils;

import java.sql.*;

public class SqlInjection {
    public static void main(String[] args) throws SQLException {
//        login("韩信","nihao");
        login("'or '1=1 ","123456");

    }
    //登录业务
    public static void login(String username,String password) throws SQLException {
        Connection coon = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            coon = JdbcUtils.getConnection();
            //prepareStatement  防止SQL注入的本质，预编译的时候把传递进来的参数当做字符
            //假设其中存在转义字符，就直接忽略，'会被直接转义
            String sql = "select * from users where NAME =? and password =?";
            st = coon.prepareStatement(sql);
            st.setString(1,username);
            st.setString(2,password);
            rs = st.executeQuery();
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
