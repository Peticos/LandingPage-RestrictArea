package com.peticos.Controller.Local;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.LocalDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdicionarLocal", value = "/areaRestrita/local/adicionar")
public class AdicionarLocal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTipoLocal = Integer.parseInt(request.getParameter("id-tipo-local"));
        String nomeLocal = request.getParameter("nome-local");
        String descricao = request.getParameter("descricao");
        String link = request.getParameter("link-saber-mais");
        String img = request.getParameter("imagem-local");

        Mensagem mensagem = new Mensagem("local", "local", request, response);


        if(!link.matches("http(s)?://.*.(com|org)(.br)?") && !img.matches("http(s)?://.*.(com|org)(.br)?")){
            mensagem.retornarMensagem("Link saber mais e link da imagem digitados com erro!");
            return;
        }
        else if(!link.matches("http(s)?://.*.(com|org)(.br)?")){
            mensagem.retornarMensagem("Link saber mais digitado com erro!");
            return;
        }
        else if(!img.matches("http(s)?://.*.(com|org)(.br)?")){
            mensagem.retornarMensagem("Link da imagem digitado com erro!");
            return;
        }

        LocalDAO dao = new LocalDAO();
        int sucesso = dao.inserirLocal(idTipoLocal, nomeLocal, descricao, link, img);

        mensagem.retornarMensagem(sucesso, 1, 'M');
    }
}
