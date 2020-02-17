package com.company.springTemplate;

import com.company.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 *      springjdbcTemlate 入门案例
 *
 */
public class SpringTemplateDemo {
    // 导包


    //创建JDBCTemplate对象
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    // 写sql


    // 执行sql


    //返回结果

}
