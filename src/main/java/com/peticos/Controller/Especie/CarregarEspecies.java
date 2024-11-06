package com.peticos.Controller.Especie;


import com.peticos.DAO.EspecieDAO;
import com.peticos.Model.Especie;
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

////
@WebServlet(name = "CarregarEspecies", value = "/areaRestrita/especie")
public class CarregarEspecies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Instanciando o DAO
        EspecieDAO dao = new EspecieDAO();

        // Definindo a lista que será enviada com as espécies
        List<Especie> especies = new ArrayList<>();

        try{
            ResultSet rs = dao.getTodasEspecies(); // Faz a consulta no banco
            while(rs.next()){
                int id = rs.getInt("id_especie");
                String especie = rs.getString("especie");
                especies.add(new Especie(id, especie));
            } // Adiciona as informações do banco na lista de espécie
        } catch (SQLException e) {
            // Caso algum erro ocorra no carregamento, envia uma mensagem avisando
            throw new ServletException("Erro ao carregar as espécies", e);
        }

        // Recuperar a mensagem da sessão, se existir
        HttpSession session = request.getSession(false);
        String message = (String) session.getAttribute("message");

        // Remover a mensagem da sessão para que ela não fique persistente
        session.removeAttribute("message");

        // Passar a mensagem para o JSP
        request.setAttribute("message", message);

        request.setAttribute("especies", especies);

        request.getRequestDispatcher("/areaRestrita/especie/especie.jsp").forward(request, response);
    }
}

