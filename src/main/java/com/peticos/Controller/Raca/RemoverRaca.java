package com.peticos.Controller.Raca;

import com.peticos.Controller.Mensagem;
import jakarta.servlet.annotation.WebServlet;
import com.peticos.DAO.RacaDAO;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RemoverRaca", value = "/areaRestrita/raca/remover")
public class RemoverRaca extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id-raca"));

        RacaDAO dao = new RacaDAO();
        int removerRaca = dao.excluirRaca(id);

        Mensagem mensagem = new Mensagem("raça", "raca", request, response);


        if (removerRaca == -2){
            mensagem.retornarMensagem("Erro de foreing key na tabela 'pet'"); // Mensagem de erro caso alguma raça esteja na tabela pet--
            return;
        }
        mensagem.retornarMensagem(removerRaca, 3, 'F');
    }
}
