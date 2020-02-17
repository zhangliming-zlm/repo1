package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *  使用Jdbc实现登录功能
 *
 *      1.在数据库中查询是否有你前期注册好的账户和密码
 *      2.如果查到账号和密码和你输入的账号和密码相匹配则显示登录成功
 *      3.账号存在，密码不匹配则显示密码错误登录不成功，请重新输入密码
 */
public class JdbcDemo4 {

    static Connection conn = null;
    static Statement statement = null;
    static ResultSet resultSet = null;

    public static void main(String[] args) {

        // 获取数据库的连接
        try {
            Connection connection = JdbcUtils.getConnection();
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入用户名...");
            String name = scan.nextLine();
            System.out.println("请输入密码...");
            String password = scan.next();

            //创建sql语句
            String sql = "select * from t_user where name = '"+name+"' and password = '"+password+"'";

            //创建statement对象
            statement = conn.createStatement();

            //使用statement对象执行sql语句
            resultSet = statement.executeQuery(sql);

            //处理结果
            if (resultSet.next()){
                System.out.println("登录成功!");
            }else{
                LoginOut(name,password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JdbcUtils.close(resultSet,statement,conn);
        }

    }

    private  static  void LoginOut(String name,String password){
        try {
            String sql = "select * from t_user where name = '\"+name+\"' or password = '\"+password+\"'\"";
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                System.out.println("用户名或者密码错误！");
            }else {
                System.out.println("登录失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
