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

@WebServlet(name = "AdicionarLocal", value = "/areaRestrita/local/adicionar")
public class AdicionarLocal extends HttpServlet {

    //Metodo doPost pegando os parametros passados pelo jsp, para adicionar um local à tabela.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTipoLocal = Integer.parseInt(request.getParameter("id-tipo-local"));
        int idEndereco = Integer.parseInt(request.getParameter("id-endereco"));
        String telefone = request.getParameter("telefone-local");
        String nomeLocal = request.getParameter("nome-local");
        String descricao = request.getParameter("descricao");
        String link = request.getParameter("link-saber-mais");
        String img = request.getParameter("imagem-local");
        String rua = request.getParameter("rua-local");
        int numero = Integer.parseInt(request.getParameter("numero-local"));

        Mensagem mensagem = new Mensagem("local", "local", request, response);

        // Validando o telefone
        int lenTelefone = telefone.replaceAll("[^0-9]*", "").length();
        boolean telefoneValido = lenTelefone == 11 || lenTelefone == 10;
        if (!telefoneValido) {
            mensagem.retornarMensagem("Telefone inválido! Faça no formato (xx) xxxxx-xxxx");
            return;
        }

        //Links apenas com dominios: .com, .org, .gov e opicionalmente o .br
        if(!link.matches("^http(s)?://.*\\.(com|org|gov)(.br)?(/.*)?") && !img.matches("(^http(s)?://.*\\.(com|org|gov)(.br)?(/.*))?")){
            mensagem.retornarMensagem("Link saber mais e link da imagem digitados com erro!");
            return;
        }
        // Regex para validar se o link saber mais é válido
        else if(!link.matches("^http(s)?://.*\\.(com|org|gov)(.br)?(/.*)?")){
            mensagem.retornarMensagem("Link saber mais digitado com erro!");
            return;
        }
        // Regex para validar se o link da imagem é válido
        else if(!img.matches("^http(s)?://.*\\.(com|org|gov)(.br)?(/.*)?")){
            mensagem.retornarMensagem("Link da imagem digitado com erro!");
            return;
        }

        //Instancia objeto dao e chama o método de inserir
        LocalDAO dao = new LocalDAO();
        Local local = new Local(idTipoLocal, idEndereco, nomeLocal, descricao, link, img, rua, numero, telefone);
        int sucesso = dao.inserirLocal(local);

        //Retorna uma mensagem de adicionado com sucesso
        mensagem.retornarMensagem(sucesso, 1, 'M');
    }
}
