package com.peticos.Controller.Administrador;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.AdministradorDAO;
import com.peticos.DAO.DicaDoDiaDAO;
import com.peticos.Model.DicaDoDia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "EditarAdministrador", value = "/areaRestrita/administradores/editar")
public class AlterarAdministrador extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idAdmin = Integer.parseInt(request.getParameter("id-administrador"));
        String nome = request.getParameter("nome-administrador");
        String email  = request.getParameter("email-administrador");

        boolean emailValido = email.matches("^[a-zA-Z0-9]+\\.?[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.(com|org)(\\.br)?$");

        Mensagem mensagem = new Mensagem("administrador", "administradores", request, response);

        if (!emailValido){
            mensagem.retornarMensagem("E-mail inválido! Digite no formato nome@dominio.com");
            return;
        }

        AdministradorDAO dao = new AdministradorDAO();
        int sucesso = dao.alterarAdministrador(idAdmin, nome,email);

        mensagem.retornarMensagem(sucesso, 2, 'M');
    }
}
