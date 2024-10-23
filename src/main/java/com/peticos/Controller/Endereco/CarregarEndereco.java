package com.peticos.Controller.Endereco;

import com.peticos.DAO.EnderecoDAO;
import com.peticos.Model.Endereco;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="CarregarEndereco", value = "/areaRestrita/endereco")
public class CarregarEndereco extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EnderecoDAO dao = new EnderecoDAO();

        List<Endereco> enderecos = new ArrayList<>();

        // Recuperar a mensagem da sessão, se existir
        HttpSession session = request.getSession(false);
        String message = (String) session.getAttribute("message");

        // Remover a mensagem da sessão para que ela não fique persistente
        session.removeAttribute("message");

        try {
            ResultSet rs = dao.getTodosEnderecos();
            while (rs.next()) {
                int id = rs.getInt("id_endereco");
                String estado = rs.getString("estado");
                String cidade = rs.getString("cidade");
                String bairro = rs.getString("bairro");
                enderecos.add(new Endereco(id, estado, cidade, bairro));
            }
        }catch(SQLException e ) {
            message = "Não foi possível carregar os enderecos. Recarregue a página e tente novamente!";
            e.printStackTrace();
        }


        // Passar a mensagem para o JSP
        request.setAttribute("message", message);

        request.setAttribute("enderecos", enderecos);
        request.getRequestDispatcher("/areaRestrita/endereco/endereco.jsp").forward(request,response);
    }
}
