package com.peticos.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kotlin.text.UStringsKt;

import java.io.IOException;

public class Mensagem {
    private final String campo;
    private final String caminho;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public Mensagem(String campo, String caminho, HttpServletRequest request, HttpServletResponse response) {
        this.campo = campo;
        this.caminho = caminho;
        this.request = request;
        this.response = response;
    }

    public void retornarMensagem(int sucesso, int tipo, char genero) throws IOException {
        String message;
        String campoCapilized = campo.substring(0, 1).toUpperCase() + campo.substring(1); // por exemplo: dica -> Dica
        char fim;

        // Define as mensagens como adicionadO ou adicionadA
        if (genero=='M'){
            fim = 'o';
        } else{
            fim = 'a';
        }

        // Verifica qual ação foi feita (1 - Adicionar, 2 - Alterar, 3 - Remover)
        switch (tipo){
            case 1 -> {
                if (sucesso > 0) {
                    message = String.format("%s adicionad%c com sucesso!", campoCapilized, fim);
                } else if (sucesso == 0) {
                    message = String.format("%c %s não foi adicionad%c..", Character.toUpperCase(fim), campo.toLowerCase(), fim);
                } else if (sucesso == -2) {
                    if (fim=='o'){
                        message = String.format("Já existe um %s com essa data!", campo.toLowerCase());
                    } else{
                        message = String.format("Já existe uma %s com essa data!", campo.toLowerCase());
                    }
                } else {
                    message = String.format("Erro ao adicionar %s!", campo.toLowerCase());
                }
            }
            case 2 -> {
                if (sucesso > 0) {
                    message = String.format("%s alterad%c com sucesso!", campoCapilized, fim);
                } else if (sucesso == 0) {
                    message = String.format("%c %s não foi alterad%c..", Character.toUpperCase(fim), campo.toLowerCase(), fim);
                } else if (sucesso == -2) {
                    if (fim=='o'){
                        message = String.format("Já existe um %s com essa data!", campo.toLowerCase());
                    } else{
                        message = String.format("Já existe uma %s com essa data!", campo.toLowerCase());
                    }
                } else {
                    message = String.format("Erro ao alterar %s!", campo.toLowerCase());
                }
            }
            case 3 -> {
                if (sucesso > 0) {
                    message = String.format("%s removid%c com sucesso!", campoCapilized, fim);
                } else if (sucesso == 0) {
                    message = String.format("%c %s não foi removid%c..", Character.toUpperCase(fim), campo.toLowerCase(), fim);
                } else {
                    message = String.format("Erro ao remover %s!", campo.toLowerCase());
                }
            }
            default -> message = "Ocorreu um erro, tente novamente (mensagem não informada/esperada).";
        }

        // Armazenar a mensagem na sessão
        request.getSession(false).setAttribute("message", message);

        // Redirecionar para o servlet que carrega a tabela
        response.sendRedirect(String.format("/areaRestrita/%s", caminho));
    }

    public void retornarMensagem(String mensagem) throws IOException {
        // Armazenar a mensagem na sessão
        request.getSession(false).setAttribute("message", mensagem);

        // Redirecionar para o servlet que carrega a tabela
        response.sendRedirect(String.format("/areaRestrita/%s", caminho));
    }
}
