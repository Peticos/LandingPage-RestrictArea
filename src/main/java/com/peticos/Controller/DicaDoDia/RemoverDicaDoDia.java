package com.peticos.Controller.DicaDoDia;

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
        int id = Integer.parseInt(request.getParameter("id_dica"));

        DicaDoDiaDAO dao = new DicaDoDiaDAO();
        int removerDicaDoDia = dao.removerDicaDoDia(id);
        String message;
        if (removerDicaDoDia > 0) {
            message = "Dica excluída com sucesso!";
        } else if (removerDicaDoDia == 0) {
            message = "A dica não foi removida..";
        } else {
            message = "Erro ao excluir a dica!";
        }

        // Armazenar a mensagem na sessão
        request.getSession(false).setAttribute("message", message);

        // Redirecionar para o servlet que carrega as dicas
        response.sendRedirect("/areaRestrita/dicasDoDia");
    }
}
