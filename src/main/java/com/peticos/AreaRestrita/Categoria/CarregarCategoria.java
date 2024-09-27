package com.peticos.AreaRestrita.Categoria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kotlin.ResultKt;
import kotlin.collections.ArrayDeque;

import java.io.IOException;
import java.io.Serial;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="CarregarCategoria", value = "/areaRestrita/categoriaPostagens")
public class CarregarCategoria extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoriaDAO dao = new CategoriaDAO();

        List<Categoria> categorias = new ArrayList<>();

        try {
            ResultSet rs = dao.getTodasAsCategorias();
            while (rs.next()) {
                int id = rs.getInt("id_categoria");
                String nome = rs.getString("nome");
                categorias.add(new Categoria(id, nome));
            }
        }catch(SQLException e ) {
            e.printStackTrace();
        }

        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("/areaRestrita/categoriaPostagens/index.jsp").forward(request,response);
    }
}
