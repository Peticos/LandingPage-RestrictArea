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
        int idEndereco = Integer.parseInt(request.getParameter("id-endereco"));
        String nomeLocal = request.getParameter("nome-local");
        String descricao = request.getParameter("descricao");
        String link = request.getParameter("link-saber-mais");
        String img = request.getParameter("imagem-local");
        String rua = request.getParameter("rua-local");
        int numero = Integer.parseInt(request.getParameter("numero-local"));

        Mensagem mensagem = new Mensagem("local", "local", request, response);



        if(!link.matches("^http(s)?://.*\\.(com|org|gov)(.br)?(/.*)?") && !img.matches("(^http(s)?://.*\\.(com|org)(.br)?(/.*))?")){
            mensagem.retornarMensagem("Link saber mais e link da imagem digitados com erro!");
            return;
        }
        else if(!link.matches("^http(s)?://.*\\.(com|org|gov)(.br)?(/.*)?")){
            mensagem.retornarMensagem("Link saber mais digitado com erro!");
            return;
        }
        // Regex para validar se o link da imagem é válido
        else if(!img.matches("^http(s)?://.*\\.(com|org)(\\.br)?(/.*)?")){
            mensagem.retornarMensagem("Link da imagem digitado com erro!");
            return;
        }

        LocalDAO dao = new LocalDAO();
        int sucesso = dao.inserirLocal(idTipoLocal, idEndereco ,nomeLocal, descricao, link, img, rua, numero);

        mensagem.retornarMensagem(sucesso, 1, 'M');
    }
}
