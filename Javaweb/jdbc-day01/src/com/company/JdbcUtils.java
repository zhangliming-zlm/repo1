package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/*
        jdbc工具类


 */
public class JdbcUtils {
    private static String url;
    private static String username;
    private static String password;
    private static String driver;

    /**
     *用静态块来加载资源，读取图片，音频，视频，配置文件
     */
    static {
        try {

//             1.创建Properties对象
            Properties pro = new Properties();
//          获取jdbc。properties文件路径 ---> ClassLoader
            ClassLoader classLoader = JdbcUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();

//            2.加载文件
//             pro.load(new FileReader("src\\jdbc.properties"));
             pro.load(new FileReader(path));

//             3.获取数据，并赋值
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
//             4.将值传入对应的方法

            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 关闭资源
     * @param resultSet
     * @param statement
     * @param con
     */
    public static void close(ResultSet resultSet, Statement statement, Connection con){
//          关闭资源
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
