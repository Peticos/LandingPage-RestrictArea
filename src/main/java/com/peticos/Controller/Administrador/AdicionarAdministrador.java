package com.peticos.Controller.Administrador;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.AdministradorDAO;
import com.peticos.Model.Administrador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdicionarAdministrador", value = "/areaRestrita/administradores/adicionar")
public class AdicionarAdministrador extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando os parâmetros enviados para o Servlet
        String nome = request.getParameter("nome-administrador");
        String email  = request.getParameter("e-mail-administrador");
        String senha = request.getParameter("senha-administrador");

        // Validando se o e-mail segue o padrão nome.sobrenome@dominio.com.br
        boolean emailValido = email.matches("^[a-zA-Z0-9]+\\.?[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.(com|org)(\\.br)?$");

        // A senha deve ter no mínimo uma minúscula, uma maiúscula, um número e um caractere especial
        boolean senhaValida = senha.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%&_\\-*]).{8,}$");

        Mensagem mensagem = new Mensagem("administrador", "administradores", request, response);

        if (!senhaValida) {
            mensagem.retornarMensagem("Senha não atende aos requisitos mínimos! (8 caracteres, 1+ minúscula/maiúscula/número/caractere especial)");
            return;
        }

        if (!emailValido){
            mensagem.retornarMensagem("E-mail inválido! Digite no formato nome.sobrenome@dominio.com.br");
            return;
        }

        AdministradorDAO dao = new AdministradorDAO();
        Administrador administrador = new Administrador(nome, email, senha);
        int sucesso = dao.inserirAdministrador(administrador);

        mensagem.retornarMensagem(sucesso, 1, 'M');
    }
}
