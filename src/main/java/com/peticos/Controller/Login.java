package com.peticos.Controller;

import com.peticos.Model.Administrador;
import com.peticos.DAO.AdministradorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Login", value = "/login/acessar")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Pega os parâmetros de e-mail e senha inseridos pelo usuário.
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        // Criando o Data Access Object de admin
        AdministradorDAO admDAO = new AdministradorDAO();

        // Pega o administrador a partir do e-mail
        Administrador administrador = admDAO.getAdmin(email);

        // Verifica se o administrador existe e se a senha fornecida é igual ao do administrador
        if ((administrador != null) && (administrador.getSenha().equals(senha))) {
            // Cria a sessão para o usuário, salvando a informação do e-mail
            HttpSession session = request.getSession();
            session.setAttribute("admin", administrador.getEmail());

            // Redirecionando para a área restrita
            response.sendRedirect("/areaRestrita/dicasDoDia");
        } else {
            // O Administrador não existe ou a senha está incorreta
            String mensagemDeErro = "E-mail e/ou senha incorreto(s)!";

            // Definindo a mensagem de erro para ser exibida na página
            request.setAttribute("erro", mensagemDeErro);

            // Mandando de volta as informações para a página
            request.getRequestDispatcher("/login/login.jsp").forward(request, response);
        }
    }
}
