package com.peticos.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.peticos.Conexao;

public class RelatorioDAO {

    public ResultSet getTodosRelatorios() {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM log_total_1 ORDER BY 4 DESC"); // Prepara a query que vai ser executada

            return conexao.pstmt.executeQuery();// Executa a query e retorna o resultado do SELECT
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }
}
