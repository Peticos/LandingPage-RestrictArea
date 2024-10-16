package com.peticos.Controller.DicaDoDia;

import com.peticos.Controller.Mensagem;
import com.peticos.DAO.DicaDoDiaDAO;
import com.peticos.Model.DicaDoDia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AdicionarDicaDoDia", value = "/areaRestrita/dicasDoDia/adicionar")
public class AdicionarDicaDoDia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando os parâmetros enviados pelo form na página
        String titulo = request.getParameter("titulo");
        String texto  = request.getParameter("texto");
        String link = request.getParameter("link");
        Date data = Date.valueOf(request.getParameter("data"));

        // Criando o objeto de mensagem que será utilizado para o retorno
        Mensagem mensagem = new Mensagem("dica", "dicasDoDia", request, response);

        // Validando o link por regex
        boolean linkValido = link.matches("^https?://.+$");
        if (!linkValido){
            mensagem.retornarMensagem("Link inválido!");
            return;
        }

        // Chamando o DAO para inserir no banco
        DicaDoDiaDAO dao = new DicaDoDiaDAO();
        DicaDoDia dica = new DicaDoDia(titulo, texto, link, data);
        int sucesso = dao.inserirDicaDoDia(dica);

        // Retornando a mensagem com base no retorno do método
        mensagem.retornarMensagem(sucesso, 1, 'F');
    }
}
