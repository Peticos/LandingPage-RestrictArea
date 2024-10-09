package com.peticos.Controller.Administrador;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.AdministradorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "AdicionarAdministrador", value = "/areaRestrita/administradores/adicionar")
public class AdicionarAdministrador extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome-administrador");
        String email  = request.getParameter("e-mail-administrador");
        String senha = request.getParameter("senha-administrador");

        boolean emailValido = email.matches("^[a-zA-Z0-9]+\\.?[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.(com|org)(\\.br)?$");

        // A senha deve ter no mínimo uma minúscula, uma maiúscula, um número e um caractere especial
        boolean temMinuscula = senha.matches(".*[a-z].*");
        boolean temMaiuscula = senha.matches(".*[A-Z].*");
        boolean temNumero = senha.matches(".*[0-9].*");
        boolean temCaractereEspecial = senha.matches(".*[!@#$%&_\\-*].*");
        boolean temOitoCaracteres = senha.matches(".{8,}");

        Mensagem mensagem = new Mensagem("administrador", "administradores", request, response);

        if (!temMinuscula || !temMaiuscula || !temNumero || !temOitoCaracteres || !temCaractereEspecial) {
            mensagem.retornarMensagem("Senha não atende aos requisitos mínimos! (8 caracteres, 1+ minúscula/maiúscula/número/caractere especial)");
            return;
        }

        if (!emailValido){
            mensagem.retornarMensagem("E-mail inválido! Digite no formato nome@dominio.com");
            return;
        }

        AdministradorDAO dao = new AdministradorDAO();
        int sucesso = dao.inserirAdministrador(nome,email,senha);

        mensagem.retornarMensagem(sucesso, 1, 'M');
    }
}
