package com.peticos.Controller.Endereco;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.EnderecoDAO;
import com.peticos.DAO.EspecieDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RemoverEndereco", value = "/areaRestrita/endereco/remover")
public class RemoverEndereco extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Instanciando uma mensagem para enviar o retorno
        Mensagem mensagem = new Mensagem("endereço", "endereco", request, response);

        try {
            // Pegando o parâmetro de Id
            int id = Integer.parseInt(request.getParameter("id"));

            // Instanciado o DAO e chamando o método para remover a espécie
            EnderecoDAO dao = new EnderecoDAO();
            int removerEndereco = dao.removerEndereco(id);

            mensagem.retornarMensagem(removerEndereco, 3, 'M');
        } catch (NumberFormatException e) {
            // Se o ID não for um número, retorna uma mensagem de erro
            e.printStackTrace();
            mensagem.retornarMensagem("Id de endereço inválido! Tente novamente.");
        }
    }
}
