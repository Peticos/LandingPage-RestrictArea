package com.peticos.Controller.Relatorio;

import com.peticos.DAO.RelatorioDAO;
import com.peticos.Model.Relatorio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CarregarRelatorio", value = "/areaRestrita/relatorio")
public class CarregarRelatorio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Instanciando o DAO
        RelatorioDAO dao = new RelatorioDAO();

        // Definindo a lista que será enviada com os relatorios
        List<Relatorio> relatorios = new ArrayList<>(); // Tabela de relatorios

        try{
            ResultSet rs = dao.getTodosRelatorios(); // Faz a consulta no banco
            while(rs.next()){

                String nomeTabela = rs.getString("table_name");
                String dataAlteracao = rs.getString("alteration_date");
                String operacao = rs.getString("operation");
                String usuario = rs.getString("user_");


                relatorios.add(new Relatorio(nomeTabela, operacao, usuario, dataAlteracao));
            } // Adiciona as informações do banco na lista relatorios
        } catch (SQLException e) {
            // Caso algum erro ocorra no carregamento, envia uma mensagem avisando
            throw new ServletException("Erro ao carregar os relatorios", e);
        }

        // Recuperar a mensagem da sessão, se existir
        HttpSession session = request.getSession(false);
        String message = (String) session.getAttribute("message");

        // Remover a mensagem da sessão para que ela não fique persistente
        session.removeAttribute("message");

        // Passar a mensagem para o JSP
        request.setAttribute("message", message);

        request.setAttribute("relatorios", relatorios);
        request.getRequestDispatcher("/areaRestrita/relatorio/relatorio.jsp").forward(request, response);
    }
}
