package com.peticos.Controller.Local;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.LocalDAO;
import com.peticos.Model.Local;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AlterarLocal", value = "/areaRestrita/local/editar")
public class AlterarLocal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idLocal = Integer.parseInt(request.getParameter("id-local"));
        int idTipoLocal = Integer.parseInt(request.getParameter("id-tipo-local"));
        String nomeLocal = request.getParameter("nome-local");
        String descricao = request.getParameter("descricao");
        String link = request.getParameter("link-saber-mais");
        String img = request.getParameter("imagem-local");

        LocalDAO dao = new LocalDAO();
        int sucesso = dao.alterarLocal(new Local(idLocal, idTipoLocal, nomeLocal, descricao, link, img));

        Mensagem.retornarMensagem(sucesso, "local", "local", request, response);
    }
}
