package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//    使用jdbc查询emp表，并将查询出来的结果封装成对象放到list集合中，最后遍历集合并打印输出
public class JdbcDemo3 {
    public static void main(String[] args) {
        List<Emp> all = findAll();
        System.out.println(all);
    }

    private static List<Emp> findAll() {
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Emp> list = new ArrayList<>();
        try {
            con = JdbcUtils.getConnection();
            String sql = "select * from emp";
            statement = con.createStatement();
            resultSet = statement.executeQuery(sql);

//   遍历结果集
            while (resultSet.next()){
//   拿数据
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int jobId = resultSet.getInt("job_Id");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int deptId = resultSet.getInt("dept_id");

                Emp emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setId(jobId);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDeptId(deptId);


                list.add(emp);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //        关闭资源
            JdbcUtils.close(resultSet,statement,con);
        }
        return list;
    }

}
