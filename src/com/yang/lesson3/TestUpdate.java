package com.yang.lesson3;

import com.yang.lesson2.untils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TestUpdate {
    public static void main(String[] args) throws SQLException {
        Connection coon =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            coon = JdbcUtils.getConnection();
            //区别
            String sql = "update users set password = ? where id = ?";
            ps = coon.prepareStatement(sql);//预编译SQL，先写SQL，然后不执行
            //手动给参数赋值

            ps.setString(1,"nihao");
            ps.setInt(2,3);

            //执行
            int i = ps.executeUpdate();
            if (i>0){
                System.out.println("更新成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(coon,ps,rs);
        }

    }
}
