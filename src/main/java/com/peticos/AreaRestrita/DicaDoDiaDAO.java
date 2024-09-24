package com.peticos.AreaRestrita;

import com.peticos.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DicaDoDiaDAO {
    private Conexao conexao;

    public DicaDoDiaDAO() {
        this.conexao = new Conexao();
    }

    public int inserirDicaDoDia(String titulo, String texto, String link, String data) {
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO dica_do_dia(titulo, texto, link, data) VALUES (?,?,?,?)");

            conexao.pstmt.setString(1, titulo);
            conexao.pstmt.setString(2, texto);
            conexao.pstmt.setString(3, link);
            conexao.pstmt.setString(4, data);

            return conexao.pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }
    public int removerDicaDoDia(int id) {
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("DELETE FROM dica_do_dia WHERE id = ?");

            conexao.pstmt.setInt(1, id);

            return conexao.pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }
    public DicaDoDia getDicaDoDia(int id) {
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM dica_do_dia WHERE id = ?");

            conexao.pstmt.setInt(1, id);

            conexao.rs = conexao.pstmt.executeQuery();
            if (conexao.rs.next()) {
                String titulo = conexao.rs.getString("titulo");
                String texto = conexao.rs.getString("texto");
                String link = conexao.rs.getString("link");
                String data = conexao.rs.getString("data");
                return new DicaDoDia(id, titulo, texto, link, data);
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
    public ResultSet getTodasDicasDoDia() {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM dica_do_dia");

            return conexao.pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }
}
