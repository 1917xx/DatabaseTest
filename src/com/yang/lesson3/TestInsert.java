package com.yang.lesson3;

import com.yang.lesson2.untils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TestInsert {
    public static void main(String[] args) throws SQLException {
        Connection coon =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            coon = JdbcUtils.getConnection();
            //区别
            String sql = "insert into users values(?,?,?,?,?)";
            ps = coon.prepareStatement(sql);//预编译SQL，先写SQL，然后不执行
            //手动给参数赋值
            ps.setInt(1,4);
            ps.setString(2,"yangbian");
            ps.setString(3,"12345678");
            ps.setString(4,"25436489@qq.com");
            //注意点：sql.Date 数据库：java.sql.Date()
            //        util.Date java new Date().getTime() 获取时间戳
            ps.setDate(5,new java.sql.Date(new Date().getTime()));

            //执行
            int i = ps.executeUpdate();
            if (i>0){
                System.out.println("插入成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(coon,ps,rs);
        }

    }
}
