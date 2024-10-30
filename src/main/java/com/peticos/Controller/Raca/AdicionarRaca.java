package com.peticos.Controller.Raca;

import jakarta.servlet.annotation.WebServlet;
import com.peticos.Controller.Mensagem;
import com.peticos.DAO.RacaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "AdicionarRaca", value = "/areaRestrita/raca/adicionar")
public class AdicionarRaca extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeRaca = request.getParameter("nome-raca");

        Mensagem mensagem = new Mensagem("raça", "raca", request, response);


        if(nomeRaca.matches(".*[0-9].*")){
            mensagem.retornarMensagem("Nome da raça não pode conter números!");
            return;
        }

        RacaDAO dao = new RacaDAO();
        int sucesso = dao.inserirRaca(nomeRaca);

        mensagem.retornarMensagem(sucesso, 1, 'F');
    }
}
