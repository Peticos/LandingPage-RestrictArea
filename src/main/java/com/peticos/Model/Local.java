package com.peticos.Model;

public class Local {
    //Criando os atributos do Model de Local
    private int idLocal;
    private int idTipoLocal;
    private int idEndereco;
    private String nomeLocal;
    private String descricao;
    private String linkSaberMais;
    private String imagemLocal;
    private String rua;
    private int numero;
    private String tipoLocal;

    //Construtor sem tipo local, não é da tabela local e sim vem de um join com a tabela tipo_local.
    public Local(int idLocal, int idTipoLocal, int idEndereco, String nomeLocal, String descricao, String linkSaberMais, String imagemLocal, String rua, int numero) {
        this.idLocal = idLocal;
        this.idTipoLocal = idTipoLocal;
        this.idEndereco = idEndereco;
        this.nomeLocal = nomeLocal;
        this.descricao = descricao;
        this.linkSaberMais = linkSaberMais;
        this.imagemLocal = imagemLocal;
        this.rua = rua;
        this.numero = numero;
    }

    //Construtor com tipoLocal, decorrente da junção das tabelas: local e tipo_local.
    public Local(int idLocal, int idTipoLocal, int idEndereco, String nomeLocal, String descricao, String linkSaberMais, String imagemLocal, String rua, int numero, String tipoLocal) {
        this.idLocal = idLocal;
        this.idTipoLocal = idTipoLocal;
        this.idEndereco = idEndereco;
        this.nomeLocal = nomeLocal;
        this.descricao = descricao;
        this.linkSaberMais = linkSaberMais;
        this.imagemLocal = imagemLocal;
        this.rua = rua;
        this.numero = numero;
        this.tipoLocal = tipoLocal;
    }

    //Getters e Setters
    public int getIdLocal() {
        return this.idLocal;
    }

    public int getIdTipoLocal() {
        return this.idTipoLocal;
    }

    public String getNomeLocal() {
        return this.nomeLocal;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getLinkSaberMais() {
        return this.linkSaberMais;
    }

    public String getImagemLocal() {
        return this.imagemLocal;
    }

    public int getIdEndereco() {
        return this.idEndereco;
    }

    public String getRua() {
        return this.rua;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getTipoLocal(){return this.tipoLocal;}

}
