package com.bibiboom.jdbc;

import java.sql.*;

public class Test2 {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://172.16.1.128/ss_game_stat?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "ss_game";
    static final String PASS = "abc321";

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT lastLoginServerId FROM tmp_reg_role_rank_list GROUP BY lastLoginServerId";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){

                int lastLoginServerId = rs.getInt("lastLoginServerId");
                // 输出数据
                System.out.println("lastLoginServerId = " + lastLoginServerId);
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("又是操蛋的一天!");
    }
}
