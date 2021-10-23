package com.yang.lesson3;

import com.yang.lesson2.untils.JdbcUtils;

import java.sql.*;

public class TestSelect {
        public static void main(String[] args) throws SQLException {
            Connection con = null;
            PreparedStatement st = null;
            ResultSet rs = null;
            try {
                con = JdbcUtils.getConnection();
                String sql = "select * from users where id = ? ";
                st = con.prepareStatement(sql);
                st.setInt(1,3);
                rs = st.executeQuery();
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
