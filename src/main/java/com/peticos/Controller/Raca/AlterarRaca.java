package com.peticos.Controller.Raca;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.RacaDAO;
import com.peticos.Model.Raca;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AlterarRaca", value = "/areaRestrita/raca/editar")
public class AlterarRaca extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Instanciando a mensagem que será utilizada para retorno
        Mensagem mensagem = new Mensagem("raça", "raca", request, response);
        try {
            // Pegando os parâmetros enviados pelo forms
            int idRaca = Integer.parseInt(request.getParameter("id"));
            String nomeRaca = request.getParameter("nome-raca");

            // Validando o raça pela regex (não pode conter números)
            if(nomeRaca.matches(".*[0-9].*")){
                mensagem.retornarMensagem("Nome da raça não pode conter números!");
                return;
            }

            // Instanciado DAO para alterar a raça
            RacaDAO dao = new RacaDAO();
            int sucesso = dao.alterarRaca(new Raca(idRaca, nomeRaca));

            // Retornando a mensagem com base no sucesso
            mensagem.retornarMensagem(sucesso, 2, 'F');
        } catch (Exception e){
            // Caso algum erro ocorra, retorna uma mensagem de erro
            e.printStackTrace();
            mensagem.retornarMensagem("Informações de parâmetros inválidas! Tente novamente.");
        }
    }
}
