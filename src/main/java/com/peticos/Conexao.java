package com.peticos;

import java.sql.*;

public class Conexao {

    public Connection conn;
    public PreparedStatement pstmt;
    public ResultSet rs;

    public boolean conectar() {
        try{
            String dbUrl = System.getenv("DB_URL");
            String dbUser = System.getenv("DB_USER");
            String dbPassword = System.getenv("DB_PASSWORD");
            
            // Informando qual driver de conexão será utilizado pelo DriverManager
            Class.forName("org.postgresql.Driver");
            // Criando a conexão com o BD
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }
        return conn != null;
    }
    public void desconectar(){
        try{
            if (conn != null && !conn.isClosed()){
                // Desconectando do BD
                conn.close();
            }
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}