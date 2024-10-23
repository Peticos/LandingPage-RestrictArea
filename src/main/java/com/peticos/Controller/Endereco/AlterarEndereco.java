package com.peticos.Controller.Endereco;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.EnderecoDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="AlterarEndereco", value = "/areaRestrita/endereco/editar")
public class AlterarEndereco extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEndereco = Integer.parseInt(request.getParameter("id-endereco"));
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");


        EnderecoDAO dao = new EnderecoDAO();
        int sucesso = dao.alterarEndereco(idEndereco, estado, cidade, bairro);

        Mensagem mensagem = new Mensagem("endereço", "endereco", request, response);
        mensagem.retornarMensagem(sucesso, 2, 'M');
    }
}
