package com.peticos.Controller.DicaDoDia;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.DicaDoDiaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoverDicaDoDia", value = "/areaRestrita/dicasDoDia/remover")
public class RemoverDicaDoDia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Instanciando uma mensagem para enviar o retorno
        Mensagem mensagem = new Mensagem("dica", "dicasDoDia", request, response);

        try{
            // Pegando o parâmetro de Id
            int id = Integer.parseInt(request.getParameter("id-dica"));

            // Instanciado o DAO e chamando o método para remover a dica
            DicaDoDiaDAO dao = new DicaDoDiaDAO();
            int removerDicaDoDia = dao.removerDicaDoDia(id);

            mensagem.retornarMensagem(removerDicaDoDia, 3, 'F');
        } catch (NumberFormatException e) {
            // Se o ID não for um número, retorna uma mensagem de erro
            e.printStackTrace();
            mensagem.retornarMensagem("Id de dica inválido! Tente novamente.");
        }
    }
}
