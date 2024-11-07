package com.peticos.DAO;

import com.peticos.Conexao;
import com.peticos.Model.Local;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LocalDAO {


    public int inserirLocal(Local local) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            PreparedStatement preparedStatement = conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO LOCAL (id_tipo_local, id_endereco ,nome_local, descricao, link_saber_mais, imagem_local, rua, numero, telefone_local) VALUES (?,?,?,?,?,?,?,?,?)");

            //Passando os valores para o comando SQL
            conexao.pstmt.setInt(1,local.getIdTipoLocal());
            conexao.pstmt.setInt(2,local.getIdEndereco());
            conexao.pstmt.setString(3, local.getNomeLocal());
            conexao.pstmt.setString(4, local.getDescricao());
            conexao.pstmt.setString(5, local.getLinkSaberMais());
            conexao.pstmt.setString(6, local.getImagemLocal());
            conexao.pstmt.setString(7, local.getRua());
            conexao.pstmt.setInt(8, local.getNumero());
            conexao.pstmt.setString(9, local.getTelefone());

            return conexao.pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    public int removerLocal(int idLocal) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            int idEndereco = getLocal(idLocal).getIdEndereco();
            // Removendo o local
            conexao.pstmt = conexao.conn.prepareStatement("DELETE FROM LOCAL WHERE ID_LOCAL = ?");
            conexao.pstmt.setInt(1, idLocal);

            return conexao.pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    public Local getLocal(int idLocal) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM LOCAL WHERE ID_LOCAL = ?");

            conexao.pstmt.setInt(1, idLocal);

            conexao.rs = conexao.pstmt.executeQuery();
            //Pegando os valores das colunas
            if (conexao.rs.next()) {
                int idTipoLocal = conexao.rs.getInt("id_tipo_local");
                int idEndereco = conexao.rs.getInt("id_endereco");
                String nomeLocal = conexao.rs.getString("nome_local");
                String descricao = conexao.rs.getString("descricao");
                String linkSaberMais = conexao.rs.getString("link_saber_mais");
                String imagemLocal = conexao.rs.getString("imagem_local");
                String rua = conexao.rs.getString("rua");
                int numero = conexao.rs.getInt("numero");
                String telefone = conexao.rs.getString("telefone_local");
            // Retornando objeto de local
                return new Local(idTipoLocal, idEndereco, nomeLocal, descricao, linkSaberMais, imagemLocal, rua, numero, telefone);
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

    public int alterarLocal(Local local) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE local SET id_tipo_local = ?,id_endereco = ? ,nome_local = ?, descricao = ?, link_saber_mais = ?, imagem_local = ?, rua = ?, numero = ?, telefone_local = ? WHERE id_local = ?");

            conexao.pstmt.setInt(1, local.getIdTipoLocal());
            conexao.pstmt.setInt(2, local.getIdEndereco());
            conexao.pstmt.setString(3, local.getNomeLocal());
            conexao.pstmt.setString(4, local.getDescricao());
            conexao.pstmt.setString(5, local.getLinkSaberMais());
            conexao.pstmt.setString(6, local.getImagemLocal());
            conexao.pstmt.setString(7, local.getRua());
            conexao.pstmt.setInt(8, local.getNumero());
            conexao.pstmt.setString(9, local.getTelefone());
            conexao.pstmt.setInt(10, local.getIdLocal());


            conexao.pstmt.executeUpdate();


            return conexao.pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            conexao.desconectar();
        }
    }

    //Pegando todos os locais
    public ResultSet getTodosLocais() {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("""
                                                              SELECT local.*
                                                                   , tipo_local.tipo
                                                                FROM local 
                                                                     INNER JOIN tipo_local ON tipo_local.id_tipo_local = local.id_tipo_local
                                                               ORDER BY local.id_local
                                                              """
                                                         );

            return conexao.pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }


}