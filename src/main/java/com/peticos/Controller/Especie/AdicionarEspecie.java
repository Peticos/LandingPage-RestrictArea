package com.peticos.Controller.Especie;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.DicaDoDiaDAO;
import com.peticos.DAO.EspecieDAO;
import com.peticos.Model.Especie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AdicionarEspecie", value = "/areaRestrita/especie/adicionar")
public class AdicionarEspecie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando o parâmetro enviado pelo form na página
        Especie especie = new Especie(request.getParameter("especie"));

        // Criando o objeto de mensagem que será utilizado para o retorno
        Mensagem mensagem = new Mensagem("espécie", "especie", request, response);

        // Validando o nome da especie por regex
        if(especie.getNome().matches(".*[0-9].*")){
            mensagem.retornarMensagem("Nome da espécie não pode conter números!");
            return;
        }

        // Chamando o DAO para inserir no banco
        EspecieDAO dao = new EspecieDAO();
        int sucesso = dao.inserirEspecie(especie);

        // Retornando a mensagem com base no retorno do método
        mensagem.retornarMensagem(sucesso, 1, 'F');
    }
}
