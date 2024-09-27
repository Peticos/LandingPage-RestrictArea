package com.peticos.AreaRestrita.Local;

public class Local {
    private int id_local;
    private String tipo_local;
    private int id_telefone_local;
    private String nome_local;
    private String descricao;
    private String link_saber_mais;
    private String imagem_local;

    public Local(int id_local, String tipo_local, int id_telefone_local,String nome_local, String descricao, String link_saber_mais, String imagem_local) {
        this.id_local = id_local;
        this.tipo_local = tipo_local;
        this.id_telefone_local = id_telefone_local;
        this.nome_local = nome_local;
        this.descricao = descricao;
        this.link_saber_mais = link_saber_mais;
        this.imagem_local = imagem_local;
    }
    public int getId_local() {
        return this.id_local;
    }
    public String getTipo_local() {
        return this.tipo_local;
    }
    public int getId_telefone_local() {
        return this.id_telefone_local;
    }
    public String getNome_local() {
        return this.nome_local;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public String getLink_saber_mais() {
        return this.link_saber_mais;
    }
    public String getimagem_local() {
        return this.imagem_local;
    }
}