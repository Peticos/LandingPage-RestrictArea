package com.peticos.Controller.DicaDoDia;

import com.peticos.Model.DicaDoDia;
import com.peticos.DAO.DicaDoDiaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
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
                Date data = rs.getDate("data");

                dicas.add(new DicaDoDia(id, titulo, texto, link, data));
            }
        } catch (SQLException e) {
            throw new ServletException("Erro ao carregar as dicas do dia", e);
        }

        // Recuperar a mensagem da sessão, se existir
        HttpSession session = request.getSession(false);
        String message = (String) session.getAttribute("message");

        // Remover a mensagem da sessão para que ela não fique persistente
        session.removeAttribute("message");

        // Passar a mensagem para o JSP
        request.setAttribute("message", message);

        // Passar as dicas para o JSP
        request.setAttribute("dicas", dicas);

        // Voltando para o JSP
        request.getRequestDispatcher("/areaRestrita/dicasDoDia/index.jsp").forward(request, response);
    }
}
