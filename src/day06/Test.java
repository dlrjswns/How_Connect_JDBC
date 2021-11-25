package day06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Test {
	public static void main(String[] args) {
		
		String oracleD = "oracle.jdbc.driver.OracleDriver";
		String mysqlD = "com.mysql.driver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jun";
		String password = "1234";
		
		System.out.println("찾고싶은 문자입력: ");
		Scanner sc = new Scanner(System.in);
//		String num = sc.next();
		String str = sc.next();
		String sql = "select * from text where b like '%"+str+"%'";
		/*
		1. JDBC 드라이버를 JVM에 로드
		2. DB에 연결 
		3. DBMS에 데이터를 read, write == SQL문을 수행
		4. DB연결 해제 
		 */
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(oracleD);
			//JDBC 드라이버를 JVM에 로드 
			
			conn = DriverManager.getConnection(url, user, password);
			//DB에 연결
			
			stmt = conn.createStatement();
			//DBMS에 데이터를 read,write를 하기위한 객체인 Statement생성
			ResultSet rs = stmt.executeQuery(sql);
			//이터레이터와 유사한 rs 
			
			if(rs == null) {
				System.out.println("없는 데이터압니다!");
			} //없는 데이터일때 rs는 null값을 갖지않는다, 이터레이터와 비슷하기에 없는
			  //데이터를 찾을때는 while문으로 돌려서 찾아야한다 
			while(rs.next()) {
				System.out.println(rs.getInt("a")+" : "+rs.getString("b"));
			}
			rs.close(); //rs는  Statement객체가 close되면 함께 close되지만 작성
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
				//DB연결 해제
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	
	}
}
