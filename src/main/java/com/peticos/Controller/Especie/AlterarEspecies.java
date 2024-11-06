package com.peticos.Controller.Especie;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.EspecieDAO;
import com.peticos.DAO.RacaDAO;
import com.peticos.Model.Especie;
import com.peticos.Model.Raca;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="alterarEspecies", value = "/areaRestrita/especie/editar")
public class AlterarEspecies extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Instanciando a mensagem que será utilizada para retorno
        Mensagem mensagem = new Mensagem("espécie", "especie", request, response);

        try {
            // Pegando os parâmetros enviados pelo forms
            String nome = request.getParameter("especie");
            int id = Integer.parseInt(request.getParameter("id"));

            // Validando a espécie pela regex (não pode conter números)
            if(nome.matches(".*[0-9].*")){
                mensagem.retornarMensagem("Nome da espécie não pode conter números!");
                return;
            }

            // Instanciado DAO para alterar a espécie
            EspecieDAO dao = new EspecieDAO();
            Especie especie = new Especie(id, nome);
            int sucesso = dao.alterarEspecie(especie);


            // Retornando a mensagem com base no sucesso
            mensagem.retornarMensagem(sucesso, 2, 'F');
        } catch (Exception e){
            // Caso algum erro ocorra, retorna uma mensagem de erro
            e.printStackTrace();
            mensagem.retornarMensagem("Informações de parâmetros inválidas! Tente novamente.");
        }
    }
}