package com.peticos.Controller.DicaDoDia;

import com.peticos.DAO.DicaDoDiaDAO;
import com.peticos.Model.DicaDoDia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "EditarDicaDoDia", value = "/areaRestrita/dicasDoDia/editar")
public class EditarDicaDoDia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String texto  = request.getParameter("texto");
        String link = request.getParameter("link");
        Date data = Date.valueOf(request.getParameter("data"));

        DicaDoDiaDAO dao = new DicaDoDiaDAO();
        int sucesso = dao.alterarDicaDoDia(new DicaDoDia(id, titulo, texto, link, data));
        String message;
        System.out.println(sucesso);
        if (sucesso > 0) {
            message = "Dica alterada com sucesso!";
        } else if (sucesso == 0) {
            message = "A dica não foi alterada..";
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
