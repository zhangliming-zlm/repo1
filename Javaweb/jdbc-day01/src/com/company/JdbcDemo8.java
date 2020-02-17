package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 *      演示如何通过jdbc来操作mysql中的事务
 *
 */
public class JdbcDemo8 {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pre1 = null;
        PreparedStatement pre2 = null;

        try {
            // 获取连接
            conn = JdbcUtils.getConnection();

            //开启事务
            conn.setAutoCommit(false);
            //定义sql语句
            String sql1 = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";

            //获取执行sql的对象
            pre1 = conn.prepareStatement(sql1);
            pre2 = conn.prepareStatement(sql2);

            //设置参数
                //给第一条sql语句加参数
            pre1.setDouble(1,500);
            pre1.setInt(2,1);
                //给第二条sql语句加参数
            pre2.setDouble(1,500);
            pre1.setInt(2,2);

            //执行sql
            pre1.executeLargeUpdate();
            pre2.executeLargeUpdate();

            //执行成功  commit
            conn.commit();
            System.out.println("事务执行成功！");
        } catch (SQLException e) {
            System.out.println("事务执行失败！");
            //执行失败  rollback()
            if (conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        e.printStackTrace();
        } finally {
            //释放资源
            JdbcUtils.close(null,pre1,conn);
            JdbcUtils.close(null,pre2,null);
        }
    }
}
