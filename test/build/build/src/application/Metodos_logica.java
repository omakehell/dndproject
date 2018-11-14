package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

	public static int getUsernumber() {
		int usern = 0;
		try {
			String content = new String(Files.readAllBytes(Paths.get("cfg")));
			usern = Integer.parseInt(content);
			System.out.println(usern);
			return usern;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usern;
	}

	public static List<String[]> getPlayers(int usernumber) {
		List<String[]> pcs = new ArrayList<String[]>();
		String[] pc  = new String[3];
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/pTmCnAwlv9", "pTmCnAwlv9",
					"2v6Ud6up6i");
			System.out.println("entra conexion");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `Pc` WHERE id_user = '"+ usernumber +"'");
			while (rs.next()) {
				pc = new String[3];
				System.out.print("Añadido al array: "+rs.getInt("id"));
				pc[0] = Integer.toString((rs.getInt("id")));
				System.out.print("Añadido al array: "+rs.getString("name"));
				pc[1] = rs.getString("name");
				System.out.print("Añadido al array: "+rs.getString("class"));
				pc[2] = rs.getString("class");
				System.out.print("Añadido al superArray: el subarray pc generado.");
				pcs.add(pc);
				System.out.println("Añadido al array de Strings: "+rs.getString("name"));
			}
			con.close();
			return pcs;
		} catch (Exception e) {
			System.out.println("error");
		}
		return pcs;
	}

}
