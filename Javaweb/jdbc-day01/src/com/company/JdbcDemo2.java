package com.company;

import java.sql.*;

/*
    DQL 语言的操作：
    使用jdbc查询emp表，并将查询出来的结果封装成对象放到list集合中，最后遍历集合并打印输出
 */
public class JdbcDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql:///jdbc", "root", "root");
            String sql = "select * from dept";
            statement = conn.createStatement();
//        执行DQL语言
            resultSet = statement.executeQuery(sql);
//        处理结果
            if (resultSet.next()){
                int id = resultSet.getInt("id");
                String dname = resultSet.getString("dname");
                String loc = resultSet.getString("loc");
                System.out.println(id);
                System.out.println(dname);
                System.out.println(loc);
            }

            resultSet.next();
            int anInt1 = resultSet.getInt(1);
            String string1 = resultSet.getString(2);
            String string11 = resultSet.getString(3);
            System.out.println(anInt1+" "+string1+" "+string11);

            resultSet.next();
            int anInt2 = resultSet.getInt(1);
            String string2 = resultSet.getString(2);
            String string12 = resultSet.getString(3);
            System.out.println(anInt2+" "+string2+" "+string12);

            resultSet.next();
            int anInt3 = resultSet.getInt(1);
            String string3 = resultSet.getString(2);
            String string13 = resultSet.getString(3);
            System.out.println(anInt3+" "+string3+" "+string13);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(resultSet,statement,conn);
        }
    }
}
