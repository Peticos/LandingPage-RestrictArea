package com.peticos.Controller.Categoria;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.CategoriaDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="AlterarCategoria", value = "/areaRestrita/categoriaPostagens/editar")
public class AlterarCategoria extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idCategoria = Integer.parseInt(request.getParameter("id-categoria"));
        String nomeCategoria = request.getParameter("nome-categoria");

        CategoriaDAO dao = new CategoriaDAO();
        int sucesso = dao.alterarCategoria(idCategoria, nomeCategoria);

        Mensagem mensagem = new Mensagem("categoria", "categoriaPostagens", request, response);
        mensagem.retornarMensagem(sucesso, 2, 'F');
    }
}
