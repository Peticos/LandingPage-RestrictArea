package com.peticos.Controller.DicaDoDia;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.DicaDoDiaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RemoverDicaDoDia", value = "/areaRestrita/dicasDoDia/remover")
public class RemoverDicaDoDia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id-dica"));

        DicaDoDiaDAO dao = new DicaDoDiaDAO();
        int removerDicaDoDia = dao.removerDicaDoDia(id);

        Mensagem.retornarMensagem(removerDicaDoDia, "dica", "dicasDoDia", request, response);
    }
}
