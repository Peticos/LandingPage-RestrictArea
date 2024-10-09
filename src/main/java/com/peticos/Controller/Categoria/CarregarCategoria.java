package com.peticos.Controller.Categoria;

import com.peticos.DAO.CategoriaDAO;
import com.peticos.Model.Categoria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
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

        // Recuperar a mensagem da sessão, se existir
        HttpSession session = request.getSession(false);
        String message = (String) session.getAttribute("message");

        // Remover a mensagem da sessão para que ela não fique persistente
        session.removeAttribute("message");

        // Passar a mensagem para o JSP
        request.setAttribute("message", message);

        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("/areaRestrita/categoriaPostagens/categorias.jsp").forward(request,response);
    }
}
