package com.peticos.Controller.Administrador;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.AdministradorDAO;
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
        String nome = request.getParameter("nome-administrador");
        String email  = request.getParameter("e-mail-administrador");
        String senha = request.getParameter("senha-administrador");

        AdministradorDAO dao = new AdministradorDAO();
        int sucesso = dao.inserirAdministrador(nome,email,senha);

        Mensagem mensagem = new Mensagem("administrador", "administradores", request, response);
        mensagem.retornarMensagem(sucesso, 1, 'M');
    }
}
