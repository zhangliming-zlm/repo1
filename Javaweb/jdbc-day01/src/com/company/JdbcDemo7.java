package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *      PreparedStatement :
 *          1. 可以防止sql注入
 *          2.执行效率比较高
 *          3.
 */


public class JdbcDemo7 {
    public static void main(String[] args) {
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement pre = null;
        try {
            //注册驱动

            //获取连接对象
                conn = JdbcUtils.getConnection();

            //定义sql语句
                String sql = "select * from t_user where name = ? and password = ?";

            //获取执行sql语句的对象PrepareStatement
            pre = conn.prepareStatement(sql);

            //给sql语句赋值
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入用户名！");
            String name = scan.nextLine();
            System.out.println("请输入密码！");
            String password = scan.nextLine();
            pre.setString(1,"jack");
            pre.setString(2,"123");

            //执行sql语句并返回结果
            resultSet = pre.getResultSet();

            //处理结果
            if (resultSet.next()){
                System.out.println("登录成功！");

            }else {
                System.out.println("登录失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JdbcUtils.close(resultSet,pre,conn);
        }
    }
}
