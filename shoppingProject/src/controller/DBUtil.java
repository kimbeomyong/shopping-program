package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
	public static Connection getConnection() throws Exception {
		Properties properties = new Properties();
		Connection con = null;//DB에 연결하기위해(localhost,id,passwd) 객체
		try {
			FileInputStream fis = new FileInputStream("src/config/db.properties");
			properties.load(fis);
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
			System.out.println("DB연결성공");
		}catch(IOException e) {
			System.out.println("["+e.toString()+"]");
		}
		return con;
	}
}
