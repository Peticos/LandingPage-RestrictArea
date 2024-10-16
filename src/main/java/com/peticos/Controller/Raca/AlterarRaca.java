package com.peticos.Controller.Raca;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.RacaDAO;
import com.peticos.Model.Raca;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AlterarRaca", value = "/areaRestrita/raca/editar")
public class AlterarRaca extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idRaca = Integer.parseInt(request.getParameter("id-raca"));
        String nomeRaca = request.getParameter("nome-raca");

        RacaDAO dao = new RacaDAO();
        int sucesso = dao.alterarRaca(new Raca(idRaca, nomeRaca));

        Mensagem mensagem = new Mensagem("raça", "raca", request, response);
        mensagem.retornarMensagem(sucesso, 2, 'F');
    }
}
