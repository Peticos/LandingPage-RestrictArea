package com.peticos.Controller.DicaDoDia;

import com.peticos.Controller.Mensagem;
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
public class AlterarDicaDoDia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String texto  = request.getParameter("texto");
        String link = request.getParameter("link");
        Date data = Date.valueOf(request.getParameter("data"));

        Mensagem mensagem = new Mensagem("dica", "dicasDoDia", request, response);

        boolean linkValido = link.matches("^https?://.+$");
        if (!linkValido){
            mensagem.retornarMensagem("Link inválido!");
            return;
        }

        DicaDoDiaDAO dao = new DicaDoDiaDAO();
        int sucesso = dao.alterarDicaDoDia(new DicaDoDia(id, titulo, texto, link, data));

        mensagem.retornarMensagem(sucesso, 2, 'F');
    }
}
