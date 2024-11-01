package com.peticos.DAO;

import com.peticos.Conexao;
import com.peticos.Model.Administrador;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorDAO {

    public int inserirAdministrador(Administrador administrador) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO administradores (NOME, EMAIL, SENHA) VALUES (?,?,?)");

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
            conexao.pstmt = conexao.conn.prepareStatement("DELETE FROM administradores WHERE ID = ?");

            conexao.pstmt.setInt(1, id);

            return conexao.pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }
    public int alterarAdministrador(Administrador adm) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE administradores SET nome = ?, email = ? WHERE id = ?");

            conexao.pstmt.setString(1, adm.getNome());
            conexao.pstmt.setString(2, adm.getEmail());
            conexao.pstmt.setInt(3, adm.getId());

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
            conexao.pstmt = conexao.conn.prepareStatement("SELECT id, nome, senha FROM administradores WHERE email = ?");

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
    public ResultSet getTodosAdmins() throws SQLException {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM administradores");
            return conexao.pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        } finally {
            conexao.desconectar();
        }
    }
}
