package com.peticos.Model;

public class Relatorio {
    // Atributos do banco
    private String nomeTabela;
    private String operacao;
    private String usuario;
    private String dataAlteracao;

    public Relatorio(String nomeTabela, String operacao, String usuario, String dataAlteracao) {
        this.nomeTabela = nomeTabela;
        this.operacao = operacao;
        this.usuario = usuario;
        this.dataAlteracao = dataAlteracao;
    }
    public String getNomeTabela() {
        return this.nomeTabela;
    }
    public String getOperacao() {
        return this.operacao;
    }
    public String getUsuario() {
        return this.usuario;
    }
    public String getDataAlteracao() {
        return this.dataAlteracao;
    }

}
