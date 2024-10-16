package com.peticos.DAO;

import com.peticos.Model.Conexao;
import com.peticos.Model.Administrador;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorDAO {

    public int inserirAdministrador(Administrador administrador) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO admin.administradores (NOME, EMAIL, SENHA) VALUES (?,?,?)");

            conexao.pstmt.setString(1, administrador.getNome());
            conexao.pstmt.setString(2, administrador.getEmail());
            conexao.pstmt.setString(3, administrador.getSenha());

            return conexao.pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }
    public int removerAdministrador(int id) {
        Conexao conexao = new Conexao();
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
    public int alterarAdministrador(int idAdmin, String nome, String email) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE admin.administradores SET nome = ?, email = ? WHERE id = ?");

            conexao.pstmt.setString(1, nome);
            conexao.pstmt.setString(2, email);
            conexao.pstmt.setInt(3, idAdmin);

            return conexao.pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }
    public Administrador getAdmin(String email) {
        Conexao conexao = new Conexao();
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
    public ResultSet getTodosAdmins(){
        Conexao conexao = new Conexao();
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM ADMIN.ADMINISTRADORES");
            return conexao.pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }
}
