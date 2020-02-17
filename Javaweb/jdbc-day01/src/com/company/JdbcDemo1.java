package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    jdbc简单入门
        1.导入驱动jar包 mysql-connecter-Java-5.1.37.jar
            1.1. 直接将jar包复制到项目中
            1.2. 添加到libarary
        2. 注册驱动
        3.获取数据库连接对象


 */
public class JdbcDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库连接对象Connection对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
        //定义sql
        String sql = "update account set balance = 1500 where id = 1";
        //获取执行sql对象 statement
        Statement statement = conn.createStatement();
        //执行sql语句，接受返回结果
        int i = statement.executeUpdate(sql);
        //处理结果
        System.out.println(i);
        //释放资源
        statement.close();
        conn.close();

    }
}
