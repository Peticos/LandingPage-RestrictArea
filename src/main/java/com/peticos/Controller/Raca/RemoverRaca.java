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
        // Instanciando uma mensagem para enviar o retorno
        Mensagem mensagem = new Mensagem("raça", "raca", request, response);

        try {
            // Pegando o parâmetro de Id
            int id = Integer.parseInt(request.getParameter("id"));

            // Instanciado o DAO e chamando o método para remover a raça
            RacaDAO dao = new RacaDAO();
            int removerRaca = dao.excluirRaca(id);


            if (removerRaca == -2) {
                mensagem.retornarMensagem("Erro de foreing key na tabela 'pet'"); // Mensagem de erro caso alguma raça esteja na tabela pet
                return;
            }
            mensagem.retornarMensagem(removerRaca, 3, 'F');
        } catch (NumberFormatException e) {
            // Se o ID não for um número, retorna uma mensagem de erro
            e.printStackTrace();
            mensagem.retornarMensagem("Id de raça inválido! Tente novamente.");
        }
    }
}
