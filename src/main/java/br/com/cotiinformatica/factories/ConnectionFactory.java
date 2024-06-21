package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// Atributos Estáticos e privados
	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://localhost:5432/bd_apiexercicio";
	private static String user = "root";
	private static String pass = "coti";


	public static Connection getConnection() throws Exception {

		Class.forName(driver);
		return DriverManager.getConnection(url, user, pass);

	}

}
