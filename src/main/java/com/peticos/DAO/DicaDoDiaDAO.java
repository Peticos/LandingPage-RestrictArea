package com.peticos.DAO;

import com.peticos.Model.Conexao;
import com.peticos.Model.DicaDoDia;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DicaDoDiaDAO {
    private Conexao conexao;

    public DicaDoDiaDAO() {
        this.conexao = new Conexao();
    }

    public int inserirDicaDoDia(String titulo, String texto, String link, Date data) {
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO dica_do_dia(titulo, texto, link, data) VALUES (?,?,?,?)");

            conexao.pstmt.setString(1, titulo);
            conexao.pstmt.setString(2, texto);
            conexao.pstmt.setString(3, link);
            conexao.pstmt.setDate(4, data);

            return conexao.pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            if (e.getMessage().contains("data_repetida")){
                return -2;
            }
            return -1;
        } finally {
            conexao.desconectar();
        }
    }
    public int removerDicaDoDia(int id) {
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("DELETE FROM dica_do_dia WHERE id_dica = ?");

            conexao.pstmt.setInt(1, id);

            return conexao.pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }
    public int alterarDicaDoDia(DicaDoDia dica) {
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE dica_do_dia SET titulo = ?, texto = ?, link = ?, data = ? WHERE id_dica = ?");

            conexao.pstmt.setString(1, dica.getTitulo());
            conexao.pstmt.setString(2, dica.getTexto());
            conexao.pstmt.setString(3, dica.getLink());
            conexao.pstmt.setDate(4, dica.getData());
            conexao.pstmt.setInt(5, dica.getId());

            return conexao.pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            if (e.getMessage().contains("data_repetida")){
                return -2;
            }
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
                Date data = conexao.rs.getDate("data");
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
