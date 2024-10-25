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
        int idTipoLocal = Integer.parseInt(request.getParameter("id-tipo-local-e"));
        int idLocal = Integer.parseInt(request.getParameter("id-local-e"));
        int idEndereco = Integer.parseInt(request.getParameter("id-endereco-e"));
        String nomeLocal = request.getParameter("nome-local-e");
        String descricao = request.getParameter("descricao-e");
        String link = request.getParameter("link-saber-mais-e");
        String img = request.getParameter("imagem-local-e");
        String rua = request.getParameter("rua-local-e");
        int numero = Integer.parseInt(request.getParameter("numero-local-e"));

        Mensagem mensagem = new Mensagem("local", "local", request, response);


        if(!link.matches("^http(s)?://.*.(com|org)(.br)?(/.*)?") && !img.matches("(^http(s)?://.*.(com|org)(.br)?(/.*))?")){
            mensagem.retornarMensagem("Link saber mais e link da imagem digitados com erro!");
            return;
        }
        else if(!link.matches("^http(s)?://.*.(com|org)(.br)?(/.*)?")){
            mensagem.retornarMensagem("Link saber mais digitado com erro!");
            return;
        }
        // Regex para validar se o link da imagem é válido
        else if(!img.matches("^http(s)?://.*\\.(com|org)(\\.br)?(/.*)?")){
            mensagem.retornarMensagem("Link da imagem digitado com erro!");
            return;
        }


        LocalDAO dao = new LocalDAO();
        int sucesso = dao.alterarLocal(new Local(idLocal, idTipoLocal, idEndereco, nomeLocal, descricao, link, img, rua, numero));

        mensagem.retornarMensagem(sucesso, 2, 'M');
    }
}
