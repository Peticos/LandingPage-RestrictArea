package com.peticos;

import java.sql.*;
import io.github.cdimascio.dotenv.Dotenv;

public class Conexao {

    public Connection conn;
    public PreparedStatement pstmt;
    public ResultSet rs;

    public boolean conectar() {
        try{
            String dbUrl = "jdbc:postgresql://db-peticos-cardosogih.k.aivencloud.com:16207/defaultdb";
            String dbUser = "avnadmin";
            String dbPassword = "AVNS_-5W7guGY9QRwA4NOolM";

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