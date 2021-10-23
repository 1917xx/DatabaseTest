package com.yang.lesson2.test;

import com.yang.lesson2.untils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
    public static void main(String[] args) throws SQLException {
        Connection coon = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            coon = JdbcUtils.getConnection();
            st = coon.createStatement();
            String sql = "delete from users where id=5";
            int i = st.executeUpdate(sql);//执行sql
            if (i>0){
                System.out.println("删除成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(coon,st,rs);
        }
    }
}
