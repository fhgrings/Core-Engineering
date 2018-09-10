package com.github.vinifkroth.coreeng.tema6.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.github.vinifroth.coreeng.tema6.exception.ConexaoException;

public class ConexaoUtil {

	private static String status = "";
	private static final String serverName = "localhost";
	private static final String mydatabase = "agenda";
	private static final String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useSSL=false";
	private static final String username = "root";
	private static final String password = "test";
	private static final String driverName = "com.mysql.cj.jdbc.Driver";

	public static Connection getConexaoMySQL() throws ConexaoException {

		try {
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(url, username, password);
			if (connection != null) {
				status = ("STATUS--->Conectado com sucesso!");
			} else {
				status = ("STATUS--->Não foi possivel realizar conexão");
			}
			return connection;

		} catch (ClassNotFoundException e) {
			throw new ConexaoException("O driver expecificado nao foi encontrado", e);
		} catch (SQLException e) {
			throw new ConexaoException("Não foi possível conectar ao banco de dados", e);

		}
	}

	public static String statusConexao() {
		return status;
	}

}
