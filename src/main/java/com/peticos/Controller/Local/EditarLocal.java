package com.peticos.Controller.Local;

import com.peticos.DAO.LocalDAO;
import com.peticos.Model.Local;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "EditarLocal", value = "/areaRestrita/local/editar")
public class EditarLocal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int tipo = Integer.parseInt(request.getParameter("tipo"));
        String nome  = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String link = request.getParameter("link");
        String img = request.getParameter("img");

        LocalDAO dao = new LocalDAO();
        int sucesso = dao.alterarLocal(new Local(id, tipo, nome, descricao, link, img));
        String message;
        System.out.println(sucesso);
        if (sucesso > 0) {
            message = "Local alterada com sucesso!";
        } else if (sucesso == 0) {
            message = "O local não foi alterado...";
        } else {
            message = "Erro ao adicionar local!";
        }

        // Armazenar a mensagem na sessão
        request.getSession(false).setAttribute("message", message);

        // Redirecionar para o servlet que carrega as dicas
        response.sendRedirect("/areaRestrita/Local");
    }
}
