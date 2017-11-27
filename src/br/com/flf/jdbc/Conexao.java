package br.com.flf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/Acervo";
    private static final String DRIVER = "org.postgresql.Driver";

    public Conexao() {}
    // Conectar ao banco
    public Connection abrir() throws Exception {
        // Registrar o driver
        Class.forName(DRIVER);
        // Capturar a conex�o
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        // Retorna a conexao aberta
        return conn;
        
    }
    
    public Connection getConection() {
    	try {
    		Class.forName(DRIVER);
            // Retorna a conexao aberta
            return DriverManager.getConnection(URL, USUARIO, SENHA);
    	}catch (Exception e){
    		throw new RuntimeException(e);
    	}

    }

    public void close(Connection conn) throws Exception {
        conn.close();
    }
}