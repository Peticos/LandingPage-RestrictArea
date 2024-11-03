package com.peticos.Controller.Endereco;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.EnderecoDAO;
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
        int id = Integer.parseInt(request.getParameter("id"));

        EnderecoDAO dao = new EnderecoDAO();
        int sucesso = dao.removerEndereco(id);

        Mensagem mensagem = new Mensagem("endereço", "endereco", request, response);
        mensagem.retornarMensagem(sucesso, 3, 'M');
    }
}
