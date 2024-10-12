package com.peticos.Controller.Raca;

import com.peticos.DAO.RacaDAO;
import com.peticos.Model.Raca;
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
@WebServlet(name = "CarregarRaca", value = "/areaRestrita/raca")
public class CarregarRaca extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RacaDAO dao = new RacaDAO();

        List<Raca> racas = new ArrayList<>(); // Tabela de raças

        try{
            ResultSet rs = dao.getTodasRacas(); // Faz a consulta no banco
            while(rs.next()){
                int idRaca = rs.getInt("id_raca");
                String raca = rs.getString("raca");

                racas.add(new Raca(idRaca, raca));
            } // Adiciona as informações do banco na lista da raça
        } catch (SQLException e) {
            throw new ServletException("Erro ao carregar os locais", e);
        }

        // Recuperar a mensagem da sessão, se existir
        HttpSession session = request.getSession(false);
        String message = (String) session.getAttribute("message");

        // Remover a mensagem da sessão para que ela não fique persistente
        session.removeAttribute("message");

        // Passar a mensagem para o JSP
        request.setAttribute("message", message);

        request.setAttribute("racas", racas);
        request.getRequestDispatcher("/areaRestrita/raca/raca.jsp").forward(request, response);
    }

}
