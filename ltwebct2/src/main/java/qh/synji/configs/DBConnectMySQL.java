package qh.synji.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import qh.synji.dao.IUserDao;
import qh.synji.dao.implement.UserDaoImplement;

public class DBConnectMySQL {
	private static String USERNAME = "qhung";

	private static String PASSWORD = "Hung3052004.";

	private static String DRIVER = "com.mysql.cj.jdbc.Driver";

	private static String URL = "jdbc:mysql://localhost:3306/_16_09_2024";

	public static Connection getConnection() throws SQLException {

		try {

			Class.forName(DRIVER);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

		return DriverManager.getConnection(URL, USERNAME, PASSWORD);

	}

	// Test chương trình. Kích phải chuột chọn run as->java application

	public static void main(String[] args) {

		try {

			new DBConnectMySQL();

			System.out.println(DBConnectMySQL.getConnection());

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
