package com.peticos.Controller.Especie;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.EspecieDAO;
import com.peticos.DAO.RacaDAO;
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

        // Instanciando uma mensagem para enviar o retorno
        Mensagem mensagem = new Mensagem("espécie", "especie", request, response);

        try {
            // Pegando o parâmetro de Id
            int id = Integer.parseInt(request.getParameter("id"));

            // Instanciado o DAO e chamando o método para remover a espécie
            EspecieDAO dao = new EspecieDAO();
            int removerEspecie = dao.removerEspecie(id);

            mensagem.retornarMensagem(removerEspecie, 3, 'F');
        } catch (NumberFormatException e) {
            // Se o ID não for um número, retorna uma mensagem de erro
            e.printStackTrace();
            mensagem.retornarMensagem("Id de espécie inválido! Tente novamente.");
        }
    }
}