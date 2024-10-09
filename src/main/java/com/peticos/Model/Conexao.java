package com.peticos.Model;

import java.sql.*;
import io.github.cdimascio.dotenv.Dotenv;

public class Conexao {

    public Connection conn;
    public PreparedStatement pstmt;
    public ResultSet rs;


    public boolean conectar() {
        try{
            Dotenv dotenv = Dotenv.configure().directory("C:\\Users\\joaocarvalho-ieg\\OneDrive - Instituto Germinare\\Área de Trabalho\\TECH\\POO\\GIT\\peticos\\.env").load();
            String dbUrl = dotenv.get("dbUrl");
            String dbUser = dotenv.get("dbUser");
            String dbPassword = dotenv.get("dbPassword");

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