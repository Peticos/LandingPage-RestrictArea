package com.peticos.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Mensagem {
    public static void retornarMensagem(int sucesso, String campo, String caminho, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String message;
        if (sucesso > 0) {
            message = String.format("%s alterado(a) com sucesso!", campo.substring(0, 1).toUpperCase()+campo.substring(1));
        } else if (sucesso == 0) {
            message = String.format("O(A) %s não foi alterado(a)..", campo.toLowerCase());
        } else if (sucesso == -2) {
            message = String.format("Já existe um(a) %s com essa data!", campo.toLowerCase());
        } else {
            message = String.format("Erro ao adicionar %s!", campo.toLowerCase());
        }

        // Armazenar a mensagem na sessão
        request.getSession(false).setAttribute("message", message);

        // Redirecionar para o servlet que carrega a tabela
        response.sendRedirect(String.format("/areaRestrita/%s", caminho));
    }
}
