package com.hb.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {
	private static final String URI = "jdbc:mysql://localhost:3306/javaweb?user=root&password=�˴������ݿ�����&useUnicode=true&characterEncoding=UTF-8";
	private static final String DRIVER =  "com.mysql.jdbc.Driver";
	public static Connection connectDB(){
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URI);
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	
	
	public static void main(String args[]) throws Exception
	{
		Connection conn = connectDB();
		if(!conn.isClosed())
		{
			System.out.println("���ݿ����ӳɹ�");
		}
	}
}
