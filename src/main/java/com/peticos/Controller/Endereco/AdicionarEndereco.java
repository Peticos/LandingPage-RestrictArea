package com.peticos.Controller.Endereco;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.EnderecoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdicionarEndereco", value = "/areaRestrita/endereco/adicionar")
public class AdicionarEndereco extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");

        EnderecoDAO dao = new EnderecoDAO();
        int sucesso = dao.inserirEndereco(estado, cidade, bairro);

        Mensagem mensagem = new Mensagem("endereço", "endereco", request, response);
        mensagem.retornarMensagem(sucesso, 1, 'M');
    }
}