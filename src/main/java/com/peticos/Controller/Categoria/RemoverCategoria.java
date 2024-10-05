package com.peticos.Controller.Categoria;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.CategoriaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "removercategoria", value = "/areaRestrita/categoriaPostagens/remover")
public class RemoverCategoria extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id-categoria"));

        CategoriaDAO dao = new CategoriaDAO();
        int sucesso = dao.removerCategoria(id);

        Mensagem mensagem = new Mensagem("categoria", "categoriaPostagens", request, response);
        mensagem.retornarMensagem(sucesso, 3, 'F');
    }
}
