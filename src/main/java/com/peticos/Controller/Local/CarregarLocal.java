package com.peticos.Controller.Local;

import com.peticos.DAO.LocalDAO;
import com.peticos.Model.Local;
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

@WebServlet(name = "CarregarLocal", value = "/areaRestrita/local")
public class CarregarLocal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDAO dao = new LocalDAO();

        List<Local> locais = new ArrayList<>();

        try{
            ResultSet rs = dao.getTodosLocais();
            while(rs.next()){
                int idLocal = rs.getInt("id_local");
                int idTipoLocal = rs.getInt("id_tipo_local");
                int idEndereco = rs.getInt("id_endereco");
                String nomeLocal= rs.getString("nome_local");
                String descricao = rs.getString("descricao");
                String linkSaberMais = rs.getString("link_saber_mais");
                String imagemLocal = rs.getString("imagem_local");
                String rua = rs.getString("rua");
                int numero = Integer.parseInt(rs.getString("numero"));

                locais.add(new Local(idLocal, idTipoLocal, idEndereco, nomeLocal, descricao, linkSaberMais, imagemLocal, rua, numero));
            }
        } catch (SQLException e) {
            throw new ServletException("Erro ao carregar os locais", e);
        }

        // Recuperar a mensagem da sessão, se existir
        HttpSession session = request.getSession(false);
        String message = (String) session.getAttribute("message");

        // Remover a mensagem da sessão para que ela não fique persistente
        session.removeAttribute("message");

        // Passar a mensagem para o JSP
        request.setAttribute("message", message);

        request.setAttribute("locais", locais);
        request.getRequestDispatcher("/areaRestrita/local/locais.jsp").forward(request, response);
    }
}
