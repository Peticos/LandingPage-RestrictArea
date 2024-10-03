package com.peticos.Controller.Categoria;

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
        int id = Integer.parseInt(request.getParameter("id_categoria"));
        CategoriaDAO dao = new CategoriaDAO();

        if (dao.removerCategoria(id) > 0) {
            response.sendRedirect("/areaRestrita/categoriaPostagens");
        }else {
            response.sendRedirect("/errorPage/index.jsp");
        }
    }
}
