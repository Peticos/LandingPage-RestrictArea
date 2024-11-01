package com.peticos.Controller.Especie;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.EspecieDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "removerEspecie", value = "/areaRestrita/especie/remover")
public class RemoverEspecies extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        EspecieDAO dao = new EspecieDAO();
        int removerEspecie = dao.removerEspecie(id);

        Mensagem mensagem = new Mensagem("espécie", "especie", request, response);
        mensagem.retornarMensagem(removerEspecie, 3, 'F');
    }
}