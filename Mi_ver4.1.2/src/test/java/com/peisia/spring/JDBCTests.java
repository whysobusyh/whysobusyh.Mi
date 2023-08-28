package com.peisia.spring;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("문제가 있다옹");
		}
	}
	
	@Test
	public void testConnection() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat","root","root");
			log.info(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
