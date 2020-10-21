package com.kinsha.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class BookingDb implements DbData {
	private static Connection conn = null;

	private BookingDb() {
	}

	public static Connection getBookingDb() {
		return conn;
	}

	static {
		try {
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PWD);

		} catch (Exception e) {
			System.out.println("Exception at BookingDb : " + e);
		}
	}

	public static void main(String[] args) {
		System.out.println(BookingDb.getBookingDb());
	}
}
