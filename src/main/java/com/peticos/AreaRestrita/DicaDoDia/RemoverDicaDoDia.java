package com.peticos.AreaRestrita.DicaDoDia;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RemoverDicaDoDia", value = "/areaRestrita/dicasDoDia/remover")
public class RemoverDicaDoDia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id_dica"));

        DicaDoDiaDAO dao = new DicaDoDiaDAO();
        int removerDicaDoDia = dao.removerDicaDoDia(id);
        String retorno;
        if (removerDicaDoDia>0){
            retorno = "Dica excluída com sucesso!";
        } else if (removerDicaDoDia==0){
            retorno = "Não foi possível excluir essa dica (dica não existente)!";
        } else {
            retorno = "Erro ao excluir dica (Verifique o back-end para mais informações)!";
        }
        response.sendRedirect("/areaRestrita/dicasDoDia?retorno=" + URLEncoder.encode(retorno, StandardCharsets.UTF_8));
    }
}
