package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
	
	// DB 접속
	// DB Driver, Url, user, password
	// mysql : com.mysql.cj.jdbc.Driver
	// url : jdbc:mysql://localhost:3306/DB명
	
	private static DatabaseConnect dbc = new DatabaseConnect();
	private Connection conn = null;
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/javadb";
	
	private DatabaseConnect() {
		try {
			//jdbc 드라이버를 로드하기 위해 사용되는 메서드
			Class.forName(jdbcDriver);
			//conn 연결시 url, user, password
			conn = DriverManager.getConnection(jdbcUrl, "javauser", "mysql");
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("드라이버를 로드할 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("연결정보가 정확하지 않습니다.");
			e.printStackTrace();
		}
	}
	
	public static DatabaseConnect getInstance() {
		return dbc;
	}
	
	public Connection geConnection() {
		return conn;
	}

}
