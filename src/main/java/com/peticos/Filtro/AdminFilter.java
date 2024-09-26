package com.peticos.Filtro;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession sessao = httpRequest.getSession(false);

        if (sessao == null || sessao.getAttribute("admin") == null) {
            // Usuário não é administrador, redirecionar para página de login
            httpRequest.getSession().setAttribute("erro", "Você precisa ser um administrador para acessar essa página!");
            httpResponse.sendRedirect("/login/login.jsp");
        } else {
            // Continuar o processamento normal se for um administrador
            chain.doFilter(request, response);
        }
    }
}
