package com.peticos.DAO;

import com.peticos.Conexao;
import com.peticos.Model.Endereco;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoDAO {
    private Conexao conexao;

    public EnderecoDAO () {
        this.conexao = new Conexao();
    }

    public int inserirEndereco(String estado, String cidade, String bairro) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO endereco(estado,cidade,bairro) VALUES (?,?,?)");
            conexao.pstmt.setString(1,estado);
            conexao.pstmt.setString(2,cidade);
            conexao.pstmt.setString(3,bairro);

            return conexao.pstmt.executeUpdate();
        }catch(SQLException e ) {
            e.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar();
        }
    }

    public int removerEndereco(int id) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("DELETE FROM endereco WHERE id_endereco = ?");
            conexao.pstmt.setInt(1,id);

            return conexao.pstmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar();
        }
    }
    public int alterarEndereco(int id, String estado, String cidade, String bairro) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE endereco SET estado = ?, cidade = ?, bairro = ? WHERE id_endereco = ?");
            conexao.pstmt.setString(1,estado);
            conexao.pstmt.setString(2,cidade);
            conexao.pstmt.setString(3,bairro);
            conexao.pstmt.setInt(4,id);

            return conexao.pstmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar();
        }
    }

    public Endereco getEndereco(int id) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM endereco WHERE id_endereco = ? ");
            conexao.pstmt.setInt(1,id);

            conexao.rs = conexao.pstmt.executeQuery();
            if(conexao.rs.next()) {
                String id_endereco = conexao.rs.getString("id_endereco");
                String estado = conexao.rs.getString("estado");
                String cidade = conexao.rs.getString("cidade");
                String bairro = conexao.rs.getString("bairro");
                return new Endereco(Integer.parseInt(id_endereco),estado, cidade, bairro);
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

    public ResultSet getTodosEnderecos() {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM endereco");
            conexao.rs = conexao.pstmt.executeQuery();
            return conexao.rs;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }
}