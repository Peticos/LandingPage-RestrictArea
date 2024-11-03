package com.peticos.Controller.Administrador;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.AdministradorDAO;
import com.peticos.DAO.DicaDoDiaDAO;
import com.peticos.Model.Administrador;
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
        // Pegando os parâmetros recebidos
        int idAdmin = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome-administrador");
        String email  = request.getParameter("e-mail-administrador");

        // Validando se o e-mail segue o padrão nome.sobrenome@dominio.com.br
        boolean emailValido = email.matches("^[a-zA-Z0-9]+\\.?[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.(com|org)(\\.br)?$");

        // Instanciando uma mensagem para ser enviada de retorno
        Mensagem mensagem = new Mensagem("administrador", "administradores", request, response);

        // Validando a regex de e-mail
        if (!emailValido){
            mensagem.retornarMensagem("E-mail inválido! Digite no formato nome.sobrenome@dominio.com.br");
            return;
        }

        // Instanciando um DAO para executar o método de acesso ao BD
        AdministradorDAO dao = new AdministradorDAO();

        // Pegando o retorno do método
        Administrador adm = new Administrador(idAdmin, nome, email);
        int sucesso = dao.alterarAdministrador(adm);

        // Retornando a mensagem conforme o retorno
        mensagem.retornarMensagem(sucesso, 2, 'M');
    }
}
