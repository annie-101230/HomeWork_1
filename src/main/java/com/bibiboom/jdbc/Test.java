package com.bibiboom.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test {

     static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
     static final String DB_URL = "jdbc:mysql://172.16.1.128/ss_game_stat?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "ss_game";
    static final String PASS = "abc321";

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        List<Integer> list = getList();
        for (Integer integer : list) {
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
                sql = "SELECT lastLoginServerId 'lastLoginServerId',ownSdkUserId 'ownSdkUserId',roleId 'roleId',payMoneySum 'payMoneySum',(@i:=@i+1) 'orderBy' FROM tmp_reg_role_rank_list t , (select @i:=0)j WHERE lastLoginServerId = " + integer.intValue() + " ORDER BY payMoneySum DESC  ";
                ResultSet rs = stmt.executeQuery(sql);

                // 展开结果集数据库
                while(rs.next()){
                    // 通过字段检索
                    pojo pojo = new pojo();
                    pojo.setRoleId(rs.getLong("roleId"));
                    pojo.setPayMoneySum(rs.getInt("payMoneySum"));
                    pojo.setLastLoginServerId(rs.getInt("lastLoginServerId"));
                    pojo.setOwnSdkUserId(rs.getLong("ownSdkUserId"));
                    pojo.setOrderBy(rs.getInt("orderBy"));
                    // 输出数据
                    System.out.print(pojo.getLastLoginServerId1());
                    System.out.print(pojo.getOwnSdkUserId1());
                    System.out.print(pojo.getRoleId1());
                    System.out.print(pojo.getPayMoneySum1());
                    System.out.println(pojo.getOrderBy1());
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
            System.out.println("又是开心的一天!");
        }

    }

    public static List<Integer> getList() {
        Connection conn = null;
        Statement stmt = null;
        List<Integer> list = new ArrayList<>();
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
                list.add(rs.getInt("lastLoginServerId"));
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
        System.out.println("又是开心的一天!");
        return list;
    }
}
