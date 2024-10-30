package com.peticos.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.peticos.Conexao;
import com.peticos.Model.Raca;


public class RacaDAO {

    public int inserirRaca(String raca) {
        Conexao conexao = new Conexao();
        try {
            conexao.conectar();
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO raca (RACA) VALUES (?)"); // Prepara a query que vai ser executada
            conexao.pstmt.setString(1, raca);
            return conexao.pstmt.executeUpdate(); // Executa a query e retorna a quantidade de raças inseridas
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    } //Fim do método

    public int alterarRaca(Raca raca) {
        Conexao conexao = new Conexao();
        try {
            conexao.conectar();
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE RACA SET RACA = ? WHERE ID_RACA = ?"); // Prepara a query que vai ser executada
            conexao.pstmt.setString(1, raca.getRaca());
            conexao.pstmt.setInt(2, raca.getId_raca());
            return conexao.pstmt.executeUpdate(); // Executa a query e retorna a quantidade de raças alteradas
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }
    public int alterarRaca(String racaAntiga, String raca) {
        Conexao conexao = new Conexao();
        try {
            conexao.conectar();
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE RACA SET RACA = ? WHERE RACA = ?"); // Prepara a query que vai ser executada
            conexao.pstmt.setString(1, raca);
            conexao.pstmt.setString(2, racaAntiga);
            return conexao.pstmt.executeUpdate(); // Executa a query e retorna a quantidade de raças alteradas
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    public int excluirRaca(int idRaca) {
        Conexao conexao = new Conexao();
        try {
            conexao.conectar();
            conexao.pstmt = conexao.conn.prepareStatement("DELETE FROM raca WHERE id_raca = ?"); // Prepara a query que vai ser executada
            conexao.pstmt.setInt(1, idRaca);
            return conexao.pstmt.executeUpdate(); // Executa a query e retorna a quantidade de raças excluídas
        } catch (SQLException e) {
            e.printStackTrace();
            if (e.getMessage().contains("pet_id_raca_fkey")){
                return -2;
            }
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    public Raca getRaca(int idRaca) { // Procura a linha pela coluna de idRaca
        Conexao conexao = new Conexao();
        try {
            conexao.conectar();
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM RACA WHERE ID_RACA = ?"); // Prepara a query que vai ser executada
            conexao.pstmt.setInt(1, idRaca);
            conexao.rs = conexao.pstmt.executeQuery(); // Executa a query e retorna o resultado do SELECT
            if (conexao.rs.next()){
                String raca = conexao.rs.getString("raca");
                return new Raca(idRaca, raca);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }

    public Raca getRaca(String raca) { // Procura a linha pela coluna de idRaca
        Conexao conexao = new Conexao();
        try {
            conexao.conectar();
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM RACA WHERE RACA = ?"); // Prepara a query que vai ser executada
            conexao.pstmt.setString(1, raca);
            conexao.rs = conexao.pstmt.executeQuery(); // Executa a query e retorna o resultado do SELECT
            if (conexao.rs.next()){
                int idRaca = conexao.rs.getInt("id_raca");
                return new Raca(idRaca, raca);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }

    public ResultSet getTodasRacas() {
        Conexao conexao = new Conexao();
        try {
            conexao.conectar();

            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM RACA"); // Prepara a query que vai ser executada

            return conexao.pstmt.executeQuery();// Executa a query e retorna o resultado do SELECT
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }
}

