package com.peticos.Controller.Administrador;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.AdministradorDAO;
import com.peticos.DAO.DicaDoDiaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RemoverAdministrador", value = "/areaRestrita/administradores/remover")
public class RemoverAdministrador extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idAdmin = Integer.parseInt(request.getParameter("id-administrador"));

        AdministradorDAO dao = new AdministradorDAO();
        int removerAdmin = dao.removerAdministrador(idAdmin);

        Mensagem mensagem = new Mensagem("administrador", "administradores", request, response);
        mensagem.retornarMensagem(removerAdmin, 3, 'M');
    }
}
