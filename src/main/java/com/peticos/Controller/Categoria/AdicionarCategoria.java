package com.peticos.Controller.Categoria;

import com.peticos.DAO.CategoriaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "adicionarCategoria", value = "/areaRestrita/Categoria/adicionar")
public class AdicionarCategoria extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeCategoria = request.getParameter("titulo");

        CategoriaDAO dao = new CategoriaDAO();
        int sucesso = dao.inserirCategoria(nomeCategoria);
        String message;
        if (sucesso > 0) {
            message = "Dica adicionada com sucesso!";
        } else if (sucesso == 0) {
            message = "A dica não foi adicionada..";
        } else {
            message = "Erro ao adicionar dica!";
        }

        request.getSession(false).setAttribute("message", message);

        request.getRequestDispatcher("/areaRestrita/categoriaPostagens");
    }
}