package com.peticos.Controller.DicaDoDia;

import com.peticos.DAO.DicaDoDiaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AdicionarDicaDoDia", value = "/areaRestrita/dicasDoDia/adicionar")
public class AdicionarDicaDoDia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String texto  = request.getParameter("texto");
        String link = request.getParameter("link");
        Date data = Date.valueOf(request.getParameter("data"));

        DicaDoDiaDAO dao = new DicaDoDiaDAO();
        int sucesso = dao.inserirDicaDoDia(titulo, texto, link, data);
        String message;
        if (sucesso > 0) {
            message = "Dica adicionada com sucesso!";
        } else if (sucesso == 0) {
            message = "A dica não foi adicionada..";
        } else if (sucesso == -2) {
            message = "Já existe um dica com essa data!";
        } else {
            message = "Erro ao adicionar dica!";
        }

        // Armazenar a mensagem na sessão
        request.getSession(false).setAttribute("message", message);

        // Redirecionar para o servlet que carrega as dicas
        response.sendRedirect("/areaRestrita/dicasDoDia");
    }
}
