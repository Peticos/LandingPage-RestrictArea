package com.peticos.DAO;

import com.peticos.Model.Conexao;
import com.peticos.Model.Local;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalDAO {


    public int inserirLocal(int idTipoLocal, String nomeLocal, String descricao, String linkSaberMais, String imagemLocal) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO LOCAL (id_tipo_local, nome_local, descricao, link_saber_mais, imagem_local) VALUES (?,?,?,?,?)");

            conexao.pstmt.setInt(1,idTipoLocal);
            conexao.pstmt.setString(2, nomeLocal);
            conexao.pstmt.setString(3, descricao);
            conexao.pstmt.setString(4, linkSaberMais);
            conexao.pstmt.setString(5, imagemLocal);

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
            // Removendo os telefones, se existirem
            conexao.pstmt = conexao.conn.prepareStatement("DELETE FROM telefone_local WHERE id_local = ?");
            conexao.pstmt.setInt(1, idLocal);
            conexao.pstmt.executeUpdate();

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
            if (conexao.rs.next()) {
                int idTipoLocal = conexao.rs.getInt("id_tipo_local");
                String nomeLocal = conexao.rs.getString("nome_local");
                String descricao = conexao.rs.getString("descricao");
                String linkSaberMais = conexao.rs.getString("link_saber_mais");
                String imagemLocal = conexao.rs.getString("imagem_local");

                return new Local(idLocal, idTipoLocal, nomeLocal, descricao, linkSaberMais, imagemLocal);
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
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE local SET id_tipo_local = ?, nome_local = ?, descricao = ?, link_saber_mais = ?, imagem_local = ? WHERE id_local = ?");

            conexao.pstmt.setInt(1, local.getIdTipoLocal());
            conexao.pstmt.setString(2, local.getNomeLocal());
            conexao.pstmt.setString(3, local.getDescricao());
            conexao.pstmt.setString(4, local.getLinkSaberMais());
            conexao.pstmt.setString(5, local.getImagemLocal());
            conexao.pstmt.setInt(6, local.getIdLocal());

            return conexao.pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            conexao.desconectar();
        }
    }

    public ResultSet getTodosLocais() {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM local");

            return conexao.pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }


}