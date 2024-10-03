package com.peticos.DAO;

import com.peticos.Model.Conexao;
import com.peticos.Model.Local;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalDAO {
    private Conexao conexao;
    public LocalDAO() {
        conexao = new Conexao();
    }

    public int inserirLocal(int tipo_local, String nome_local, int id_telefone_local,String descricao, String link_saber_mais, String imagem_local) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO LOCAL (tipo_local, nome_local, id_telefone_local,descricao, link_saber_mais, imagem_local) VALUES (?,?,?,?, ?)");
            conexao.pstmt.setInt(1,tipo_local);
            conexao.pstmt.setString(2, nome_local);
            conexao.pstmt.setInt(3, id_telefone_local);
            conexao.pstmt.setString(3, descricao);
            conexao.pstmt.setString(4, link_saber_mais);
            conexao.pstmt.setString(5, imagem_local);
            return conexao.pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    public int removerLocal(int id_local) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("DELETE FROM LOCAL WHERE ID_LOCAL = ?");
            conexao.pstmt.setInt(1, id_local);
            return conexao.pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    public Local getLocal(int id_local) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM LOCAL WHERE ID_LOCAL = ?");
            conexao.pstmt.setInt(1, id_local);
            conexao.rs = conexao.pstmt.executeQuery();
            if (conexao.rs.next()) {

                return new Local(id_local, conexao.rs.getString("tipo_local"), conexao.rs.getInt("id_telefone_local"), conexao.rs.getString("nome_local"),
                        conexao.rs.getString("descricao"),conexao.rs.getString("link_local"),
                        conexao.rs.getString("link_imagem_local"));
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

    public ResultSet getTodosLocais() {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM local");
            conexao.rs = conexao.pstmt.executeQuery();
            return conexao.rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }


}