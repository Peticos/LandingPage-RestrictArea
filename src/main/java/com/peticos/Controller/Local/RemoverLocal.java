package com.peticos.Controller.Local;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.DicaDoDiaDAO;
import com.peticos.DAO.EspecieDAO;
import com.peticos.DAO.LocalDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RemoverLocal", value = "/areaRestrita/local/remover")
public class RemoverLocal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Instanciando uma mensagem para enviar o retorno
        Mensagem mensagem = new Mensagem("local", "local", request, response);

        try {
            // Pegando o parâmetro de Id
            int id = Integer.parseInt(request.getParameter("id"));

            // Instanciado o DAO e chamando o método para remover a espécie
            LocalDAO dao = new LocalDAO();
            int removerLocal = dao.removerLocal(id);

            mensagem.retornarMensagem(removerLocal, 3, 'M');
        } catch (NumberFormatException e) {
            // Se o ID não for um número, retorna uma mensagem de erro
            e.printStackTrace();
            mensagem.retornarMensagem("Id de local inválido! Tente novamente.");
        }
    }
}
