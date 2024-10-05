package com.peticos.Controller.Local;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.DicaDoDiaDAO;
import com.peticos.DAO.LocalDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RemoverLocal", value = "/areaRestrita/local/remover")
public class RemoverLocal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id-local"));

        LocalDAO dao = new LocalDAO();
        int removerLocal = dao.removerLocal(id);

        Mensagem.retornarMensagem(removerLocal, "local", "local", request, response);
    }
}
