package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {

    public static Connection getConnection() {
    	Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.out.println("JDBC 클래스가 없습니다. 확인하세요");
        }
        String connectionString = "jdbc:mysql://gondr.asuscomm.com/yy_20202?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Seoul";
        String dbUser = "yy_20202";
        String dbPass = "1234";

        try {
            conn = DriverManager.getConnection(connectionString, dbUser, dbPass);
            System.out.println("DB 연결 성공");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("DB 연결실패, 연결스트링과 DB테이블명, 유저이름 등을 확인하세요");
        }
        return conn;
    }
}