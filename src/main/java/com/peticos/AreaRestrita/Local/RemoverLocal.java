package com.peticos.AreaRestrita.Local;

import com.peticos.AreaRestrita.DicaDoDia.DicaDoDiaDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RemoverLocal", value = "/areaRestrita/local/remover")
public class RemoverLocal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id_local"));

        DicaDoDiaDAO dao = new DicaDoDiaDAO();
        if (dao.removerDicaDoDia(id)>0){
            response.sendRedirect("/areaRestrita/local/");
        } else {
            // Erro (ou id não existe (=0) ou deu erro no banco (-1)
        }
    }
}
