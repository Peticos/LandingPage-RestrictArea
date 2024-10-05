package com.peticos.Controller.Local;

import com.peticos.DAO.LocalDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AdicionarLocal", value = "/areaRestrita/local/adicionar")
public class AdicionarLocal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        int tipoLocal = Integer.parseInt(request.getParameter("tipo"));
        String descricao  = request.getParameter("descricao");
        String link = request.getParameter("link");
        String img = request.getParameter("img");

        LocalDAO dao = new LocalDAO();
        int sucesso = dao.inserirLocal(tipoLocal, nome, descricao, link, img);
        String message;
        System.out.println(sucesso);
        if (sucesso > 0) {
            message = "Local adicionado com sucesso!";
        } else if (sucesso == 0) {
            message = "Local não foi adicionado..";
        }
        else {
            message = "Erro ao adicionar local!";
        }

        // Armazenar a mensagem na sessão
        request.getSession(false).setAttribute("message", message);

        response.sendRedirect("/areaRestrita/local/");
    }
}
