package com.jatin;

import java.sql.Connection;
import java.sql.SQLException;
public class ConnectionUtils {

	public static Connection getConnection()throws SQLException,ClassNotFoundException
	{
		return MySQLConnUtils.getMySQLConnection();
	}
	public static void main(String[] args)throws SQLException,ClassNotFoundException
	{
		System.out.println("get connection");
		Connection conn=ConnectionUtils.getConnection();
		System.out.println("get connection"+conn);
		System.out.println("done");
	}
}
