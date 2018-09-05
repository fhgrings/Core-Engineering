package com.github.rafaritter44.core_eng.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/agenda?useSSL=false";
    private static final String USUARIO = "root";
    private static final String SENHA = "test";

    public Connection getConexao() throws Exception {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch(SQLException excecao) {
            excecao.printStackTrace();
            throw excecao;
        }
    }

}
