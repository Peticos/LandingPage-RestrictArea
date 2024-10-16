package com.peticos.Controller.Especie;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.EspecieDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="alterarnomecategoria", value = "/areaRestrita/categoriaPostagens/alterar-categoria")
public class AlterarEspecies extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("especie");
        int id = Integer.parseInt(request.getParameter("id-especie"));

        EspecieDAO dao = new EspecieDAO();
        int sucesso = dao.alterarEspecie(id,nome);

        Mensagem mensagem = new Mensagem("especie", "especie", request, response);
        mensagem.retornarMensagem(sucesso, 2, 'F');
    }
}