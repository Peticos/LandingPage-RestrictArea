package com.peticos.AreaRestrita.Categoria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="alterarnomecategoria", value = "/alterar-categoria")
public class AlterarNomeCategoria extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        int id = Integer.parseInt(request.getParameter("id_categoria"));

        CategoriaDAO dao = new CategoriaDAO();

        if (dao.alterarCategoria(id,nome) > 0) {
            response.sendRedirect("index.jsp");
        }else {
            response.sendRedirect("/areaRestrita/errorPage/index.jsp");
        }
    }
}
