package com.peticos.Controller.Especie;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.DicaDoDiaDAO;
import com.peticos.DAO.EspecieDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AdicionarEspecie", value = "/areaRestrita/especie/adicionar")
public class AdicionarEspecie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeEspecie = request.getParameter("especie");

        EspecieDAO dao = new EspecieDAO();
        int sucesso = dao.inserirEspecie(nomeEspecie);

        Mensagem mensagem = new Mensagem("especie", "especie", request, response);
        mensagem.retornarMensagem(sucesso, 1, 'F');
    }
}
