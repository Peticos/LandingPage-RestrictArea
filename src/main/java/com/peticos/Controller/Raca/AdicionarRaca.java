package com.peticos.Controller.Raca;

import com.peticos.Model.Raca;
import jakarta.servlet.annotation.WebServlet;
import com.peticos.Controller.Mensagem;
import com.peticos.DAO.RacaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "AdicionarRaca", value = "/areaRestrita/raca/adicionar")
public class AdicionarRaca extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando o parâmetro enviado pelo form na página
        Raca raca = new Raca(request.getParameter("nome-raca"));

        // Criando o objeto de mensagem que será utilizado para o retorno
        Mensagem mensagem = new Mensagem("raça", "raca", request, response);

        // Validando o nome da raça por regex
        if(raca.getRaca().matches(".*[0-9].*")){
            mensagem.retornarMensagem("Nome da raça não pode conter números!");
            return;
        }

        // Chamando o DAO para inserir no banco
        RacaDAO dao = new RacaDAO();
        int sucesso = dao.inserirRaca(raca);

        // Retornando a mensagem com base no retorno do método
        mensagem.retornarMensagem(sucesso, 1, 'F');
    }
}
