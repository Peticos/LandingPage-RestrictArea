package com.peticos.AreaRestrita.Categoria;

import com.peticos.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaDAO {
    private Conexao conexao;

    public CategoriaDAO () {
        this.conexao = new Conexao();
    }

    public int inserirCategoria(int id_categoria, String nome) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO categoria(id_categoria,nome) VALUES (?,?)");
            conexao.pstmt.setInt(1,id_categoria);
            conexao.pstmt.setString(2,nome);

            return conexao.pstmt.executeUpdate();
        }catch(SQLException e ) {
            e.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar();
        }
    }

    public int removerCategoria(int id) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("DELETE FROM categoria WHERE id_categoria = ?");
            conexao.pstmt.setInt(1,id);

            return conexao.pstmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar();
        }
    }

    public int alterarCategoria(int id, String nome) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("ALTER TABLE categoria SET nome = ? WHERE id_categoria = ?");
            conexao.pstmt.setString(1,nome);
            conexao.pstmt.setInt(2,id);

            return conexao.pstmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar();
        }
    }

    public Categoria getCategoria(int id) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM categoria WHERE id_categoria = ? ");
            conexao.pstmt.setInt(1,id);

            conexao.rs = conexao.pstmt.executeQuery();
            if(conexao.rs.next()) {
                String id_categoria = conexao.rs.getString("id_categoria");
                String nome = conexao.rs.getString("nome");
                return new Categoria(Integer.parseInt(id_categoria),nome);
            }else {
                return null;
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }

    public ResultSet getTodasAsCategorias() {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM categoria");

            return conexao.pstmt.executeQuery();
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }
}
