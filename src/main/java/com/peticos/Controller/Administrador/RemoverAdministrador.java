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
        // Já instanciando a mensagem para caso não seja passado um número como parâmetro
        Mensagem mensagem = new Mensagem("administrador", "administradores", request, response);

        try{
            // Pegando o ID do admin pelo parâmetro e tentando o converter para int
            int idAdmin = Integer.parseInt(request.getParameter("id-administrador"));

            // Instanciando o DAO para acessar o BD
            AdministradorDAO dao = new AdministradorDAO();

            // Tentando remover
            int removerAdmin = dao.removerAdministrador(idAdmin);

            // Retorna a mensagem de sucesso de acordo com o retorno do método
            mensagem.retornarMensagem(removerAdmin, 3, 'M');
        } catch (NumberFormatException e){
            // Caso não seja um número, retorna uma mensagem de erro
            e.printStackTrace();
            mensagem.retornarMensagem("O ID de Administrador deve ser um número!");
        }
    }
}
