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
    private String telefone;

    //Construtor sem tipo local, não é da tabela local e sim vem de um join com a tabela tipo_local.
    public Local(int idLocal, int idTipoLocal, int idEndereco, String nomeLocal, String descricao, String linkSaberMais, String imagemLocal, String rua, int numero, String telefone) {
        this.idLocal = idLocal;
        this.idTipoLocal = idTipoLocal;
        this.idEndereco = idEndereco;
        this.nomeLocal = nomeLocal;
        this.descricao = descricao;
        this.linkSaberMais = linkSaberMais;
        this.imagemLocal = imagemLocal;
        this.rua = rua;
        this.numero = numero;
        this.telefone = telefone;
    }

    //Construtor com tipoLocal, decorrente da junção das tabelas: local e tipo_local.
    public Local(int idLocal, int idTipoLocal, int idEndereco, String nomeLocal, String descricao, String linkSaberMais, String imagemLocal, String rua, int numero, String tipoLocal, String telefone) {
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
        this.telefone = telefone;
    }

    //Construtor sem ID LOCAL para inserir no banco
    public Local(int idTipoLocal, int idEndereco, java.lang.String nomeLocal, java.lang.String descricao, java.lang.String linkSaberMais, java.lang.String imagemLocal, java.lang.String rua, int numero, java.lang.String telefone) {
        this.idTipoLocal = idTipoLocal;
        this.idEndereco = idEndereco;
        this.nomeLocal = nomeLocal;
        this.descricao = descricao;
        this.linkSaberMais = linkSaberMais;
        this.imagemLocal = imagemLocal;
        this.rua = rua;
        this.numero = numero;
        this.telefone = telefone;
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

    public String getTelefone() {
        return telefone;
    }

    public String getTelefoneFormatado(){
        String ddd = telefone.substring(0, 2);
        String primeiraParte = telefone.substring(2, 7);
        String segundaParte = telefone.substring(7);

        return String.format("(%s) %s-%s", ddd, primeiraParte, segundaParte);
    }
}
