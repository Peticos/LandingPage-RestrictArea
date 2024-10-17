package com.peticos.Controller.Administrador;

import com.peticos.Model.Administrador;
import com.peticos.DAO.AdministradorDAO;
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

@WebServlet(name = "CarregarAdministradores", value = "/areaRestrita/administradores")
public class CarregarAdministradores extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdministradorDAO dao = new AdministradorDAO();

        // Definindo a lista de administradores que será retornada
        List<Administrador> administradores = new ArrayList<>();

        // Recuperar a mensagem da sessão, se existir
        HttpSession session = request.getSession(false);
        String message = (String) session.getAttribute("message");

        // Remover a mensagem da sessão para que ela não fique persistente
        session.removeAttribute("message");

        try{
            // Pegando o resultado do select e adicionando a lista cada admin
            ResultSet rs = dao.getTodosAdmins();
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                administradores.add(new Administrador(id, nome, email));
            }
        } catch (SQLException e) {
            message = "Não foi possível carregar os administradores. Recarregue a página e tente novamente!";
        }

        // Passar a mensagem para o JSP
        request.setAttribute("message", message);

        request.setAttribute("administradores", administradores);
        request.getRequestDispatcher("/areaRestrita/administradores/admins.jsp").forward(request, response);
    }
}
