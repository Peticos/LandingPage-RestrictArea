package com.peticos;

import java.sql.SQLException;

public class AdministradorDAO {
    private Conexao conexao;

    public AdministradorDAO() {
        conexao = new Conexao();
    }

    public int adicionarAdmin(String nome, String email, String senha) {
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO admin.administradores (NOME, EMAIL, SENHA) VALUES (?,?,?)");

            conexao.pstmt.setString(1, nome);
            conexao.pstmt.setString(2, email);
            conexao.pstmt.setString(3, senha);

            return conexao.pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }
    public int removerAdmin(int id) {
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("DELETE FROM admin.administradores WHERE ID = ?");

            conexao.pstmt.setInt(1, id);

            return conexao.pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }
    public Administrador getAdmin(String email) {
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("SELECT id, nome, senha FROM admin.administradores WHERE email = ?");

            conexao.pstmt.setString(1, email);

            conexao.rs = conexao.pstmt.executeQuery();
            if (conexao.rs.next()) {
                int id = conexao.rs.getInt("id");
                String nome = conexao.rs.getString("nome");
                String senha = conexao.rs.getString("senha");

                return new Administrador(id, nome, email, senha);
            } else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }

}
