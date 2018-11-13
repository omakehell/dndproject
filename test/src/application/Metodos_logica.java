package application;

import java.sql.*;
import java.util.UUID;

public class Metodos_logica {
	public static int login_comprobar(String user, String password) {
		int nuser = 0;
		System.out.println("entra metodo");
		try {
			System.out.println("entra try");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/pTmCnAwlv9", "pTmCnAwlv9",
					"2v6Ud6up6i");
			System.out.println("entra conexion");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM `User` WHERE name = '" + user + "' and password = '" + password + "'");
			System.out.println("entra query");
			while (rs.next()) {

				System.out.println(rs.getString("name") + "  " + rs.getString("password"));

				return nuser = rs.getInt("id");
			}
			con.close();

		} catch (Exception e) {
			System.out.println("error");
		}
		return nuser;
	}

	public static String Recovery_code() {
		return UUID.randomUUID().toString().substring(0, 11);
	}

	public static void login_btn_register(String user, String password, String recovery_code) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/pTmCnAwlv9", "pTmCnAwlv9",
					"2v6Ud6up6i");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO `User`(`name`, `password`, `recovery_code`) VALUES ('" + user + "','"
					+ password + "','" + recovery_code + "')");
			System.out.println("entra query");

			con.close();

		} catch (Exception e) {
			System.out.println("no entra algo en la query");
		}

	}

	public static void login_btn_recover() {

	}

	public static int checkUser(String user) {
		int nuser = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/pTmCnAwlv9", "pTmCnAwlv9",
					"2v6Ud6up6i");
			System.out.println("entra conexion");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `User` WHERE name = '" + user + "'");
			while (rs.next()) {

				System.out.println(rs.getString("name"));

				return nuser = rs.getInt("id");
			}
			con.close();

		} catch (Exception e) {
			System.out.println("error");
		}
		return nuser;

	}

}
