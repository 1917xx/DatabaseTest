package com.yang.lesson1;

import java.sql.*;

public class CrmDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");//固定写法，加载驱动

        //2.用户信息和url
        //useUnicode=true&characterEncoding=utf8&useSSL=true
        String url = "jdbc:mysql://121.40.138.12:13308/xtcrm?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String username ="root";
        String password = "Qu0zSs2iRNsh7fNo";

        //3.连接成功，数据库对象 Connection代表数据库
        Connection connection = DriverManager.getConnection(url,username,password);

        //4.执行SQL的对象 Statement执行SQL的对象
        Statement statement = connection.createStatement();

        //5.执行SQL的对象，去执行SQL 可能存在结果，查看返回结果
        String sql = "SELECT * FROM clues_level";

        ResultSet resultSet = statement.executeQuery(sql);//返回的结果集，结果集中封装了我们全部的查询出来的结果

        while(resultSet.next()){
            System.out.println("id="+resultSet.getObject("customer_label"));
            System.out.println("name="+resultSet.getObject("customer_type"));
        }
        //6.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
