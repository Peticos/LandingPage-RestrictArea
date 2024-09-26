package com.peticos.AreaRestrita.DicaDoDia;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RemoverDicaDoDia", value = "/areaRestrita/dicasDoDia/remover")
public class RemoverDicaDoDia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id_dica"));

        DicaDoDiaDAO dao = new DicaDoDiaDAO();
        if (dao.removerDicaDoDia(id)>0){
            response.sendRedirect("/areaRestrita/dicasDoDia/");
        } else {
            // Erro (ou id não existe (=0) ou deu erro no banco (-1)
        }
    }
}
