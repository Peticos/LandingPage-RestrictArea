package com.peticos.Controller.DicaDoDia;

import com.peticos.Controller.Mensagem;
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

        Mensagem.retornarMensagem(sucesso, "dica", "dicasDoDia", request, response);
    }
}
