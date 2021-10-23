package com.yang.lesson2.test;

import com.yang.lesson2.untils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {
        public static void main(String[] args) throws SQLException {
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
            try {
                con = JdbcUtils.getConnection();//获取数据库连接
                st = con.createStatement();//创建执行sql的对象
                String sql = "select * from users";
                rs = st.executeQuery(sql);
                //if只能查出一条数据  这里查询所有用户信息使用while
                while (rs.next()){
                    System.out.println("id="+rs.getInt("id"));
                    System.out.println("name="+rs.getString("name"));
                    System.out.println("password="+rs.getString("password"));
                    System.out.println("email="+rs.getString("email"));
                    System.out.println("birthday="+rs.getDate("birthday"));
                    System.out.println("==========================");
                }
                System.out.println("查询成功!");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                JdbcUtils.release(con,st,rs);
            }
        }
}
