package com.peticos.DAO;
import com.peticos.Conexao;
import com.peticos.Model.Especie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EspecieDAO {


//    MÉTODOS
    public int inserirEspecie(Especie especie) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO ESPECIE (especie) VALUES (?)");
            conexao.pstmt.setString(1, especie.getNome());
            return conexao.pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    public int removerEspecie(int idEspecie) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("DELETE FROM ESPECIE WHERE ID_ESPECIE = ?");
            conexao.pstmt.setInt(1, idEspecie);
            return conexao.pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    public ResultSet getTodasEspecies() {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM ESPECIE");

            return conexao.pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }
    public int alterarEspecie(Especie especie) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE especie SET especie = ? WHERE id_especie = ?");
            conexao.pstmt.setString(1, especie.getNome());
            conexao.pstmt.setInt(2,especie.getId());

            return conexao.pstmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar();
        }
    }
}