package com.peticos.AreaRestrita;

import com.peticos.Administrador;
import com.peticos.AdministradorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Pega os parâmetros de e-mail e senha inseridos pelo usuário.
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        AdministradorDAO admDAO = new AdministradorDAO();

        // Pega o administrador a partir do e-mail
        Administrador administrador = admDAO.getAdmin(email);

        // Se o administrador existe
        if (administrador != null) {
            // Verifica se a senha fornecida é igual ao do administrador
            if (administrador.getSenha().equals(senha)) {
                // Redireciona para a área restrita
                HttpSession session = request.getSession();
                session.setAttribute("admin", administrador.getEmail());
                response.sendRedirect("areaRestrita/index.jsp");
            }
        }
    }
}
