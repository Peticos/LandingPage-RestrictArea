package com.peticos.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Logout", value = "/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém a sessão atual, se existir
        HttpSession session = request.getSession(false);

        // Se a sessão existir, invalida
        if (session != null) {
            session.invalidate();
        }

        // Redireciona o usuário para a página de login
        response.sendRedirect("/login/login.jsp");
    }
}
