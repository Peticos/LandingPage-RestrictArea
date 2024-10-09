package com.peticos.Controller.Categoria;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.CategoriaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "adicionarCategoria", value = "/areaRestrita/categoriaPostagens/adicionar")
public class AdicionarCategoria extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeCategoria = request.getParameter("nome-categoria");

        Pattern pattern = Pattern.compile("[^0-9]*");
        Matcher matcher = pattern.matcher(nomeCategoria);
        boolean match = matcher.matches();
        if (match) {
            CategoriaDAO dao = new CategoriaDAO();
            int sucesso = dao.inserirCategoria(nomeCategoria);

            Mensagem mensagem = new Mensagem("categoria", "categoriaPostagens", request, response);
            mensagem.retornarMensagem(sucesso, 1, 'F');
        }else {
            Mensagem mensagem = new Mensagem("categoria", "categoriaPostagens", request, response);

        }
    }
}