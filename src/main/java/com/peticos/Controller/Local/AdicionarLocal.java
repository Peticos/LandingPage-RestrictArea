package com.peticos.Controller.Local;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.LocalDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AdicionarLocal", value = "/areaRestrita/local/adicionar")
public class AdicionarLocal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTipoLocal = Integer.parseInt(request.getParameter("id-tipo-local"));
        String nomeLocal = request.getParameter("nome-local");
        String descricao = request.getParameter("descricao");
        String link = request.getParameter("link-saber-mais");
        String img = request.getParameter("imagem-local");

        LocalDAO dao = new LocalDAO();
        int sucesso = dao.inserirLocal(idTipoLocal, nomeLocal, descricao, link, img);

        Mensagem mensagem = new Mensagem("local", "local", request, response);
        mensagem.retornarMensagem(sucesso, 1, 'M');
    }
}
