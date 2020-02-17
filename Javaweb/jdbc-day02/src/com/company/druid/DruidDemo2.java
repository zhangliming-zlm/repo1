package com.company.druid;

import com.company.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;


public class DruidDemo2 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pre = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
            pre = connection.prepareStatement(sql);
//      往sql语句中插入一些值
            pre.setInt(1,1015);
            pre.setString(2,"曹操");
            pre.setInt(3,3);
            pre.setInt(4,1007);
            pre.setDate(5,new Date(2001-01-29));
            pre.setDouble(6,8000);
            pre.setDouble(7,200);
            pre.setInt(8,2);
            int i = pre.executeUpdate();
            System.out.println(i);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,pre,connection);
        }

    }
}
