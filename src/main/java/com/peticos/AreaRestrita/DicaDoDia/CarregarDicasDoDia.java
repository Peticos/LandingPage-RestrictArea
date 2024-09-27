package com.peticos.AreaRestrita.DicaDoDia;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CarregarDicasDoDia", value = "/areaRestrita/dicasDoDia")
public class CarregarDicasDoDia extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DicaDoDiaDAO dao = new DicaDoDiaDAO();

        List<DicaDoDia> dicas = new ArrayList<>();

        try{
            ResultSet rs = dao.getTodasDicasDoDia();
            while(rs.next()){
                int id = rs.getInt("id_dica");
                String titulo = rs.getString("titulo");
                String texto = rs.getString("texto");
                String link = rs.getString("link");
                String data = rs.getString("data");

                dicas.add(new DicaDoDia(id, titulo, texto, link, data));
            }
        } catch (SQLException e) {
            throw new ServletException("Erro ao carregar as dicas do dia", e);
        }

        request.setAttribute("dicas", dicas);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
