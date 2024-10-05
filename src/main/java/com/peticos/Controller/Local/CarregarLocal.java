package com.peticos.Controller.Local;

import com.peticos.DAO.LocalDAO;
import com.peticos.Model.Local;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
                int idLocalreturn = rs.getInt("id_local");
                int tipoLocal = rs.getInt("id_tipo_local");
                String nomeLocal= rs.getString("nome_local");
                String descricao = rs.getString("descricao");
                String link_saber_mais = rs.getString("link_saber_mais");
                String imagem_local = rs.getString("imagem_local");

                locais.add(new Local(idLocalreturn, tipoLocal, nomeLocal,descricao, link_saber_mais, imagem_local));
            }
        } catch (SQLException e) {
            throw new ServletException("Erro ao carregar os locais", e);
        }
        request.setAttribute("locais", locais);
        request.getRequestDispatcher("/areaRestrita/local/locais.jsp").forward(request, response);
    }
}
