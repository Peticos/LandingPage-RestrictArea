package com.peticos.Controller.Categoria;

import com.peticos.DAO.CategoriaDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="alterarnomecategoria", value = "/areaRestrita/categoriaPostagens/alterar-categoria")
public class AlterarCategoria extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        int id = Integer.parseInt(request.getParameter("id_categoria"));

        CategoriaDAO dao = new CategoriaDAO();

        if (dao.alterarCategoria(id,nome) > 0) {
            response.sendRedirect("/areaRestrita/categoriaPostagens");
        }else {
            response.sendRedirect("/errorPage/index.jsp");
        }
    }
}
