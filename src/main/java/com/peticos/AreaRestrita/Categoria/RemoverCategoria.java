package com.peticos.AreaRestrita.Categoria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
@WebServlet(name = "removercategoria", value = "/carregar-categoria")
public class RemoverCategoria extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_categoria"));
        CategoriaDAO dao = new CategoriaDAO();

        if (dao.removerCategoria(id) > 0) {
            response.sendRedirect("index.jsp");
        }else {
            response.sendRedirect("/areaRestrita/errorPage/index.jsp");
        }
    }
}
