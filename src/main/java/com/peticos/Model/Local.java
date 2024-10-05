package com.peticos.Model;

public class Local {
    private int idLocal;
    private int idTipoLocal;
    private String nomeLocal;
    private String descricao;
    private String linkSaberMais;
    private String imagemLocal;

    public Local(int idLocal, int idTipoLocal, String nomeLocal, String descricao, String linkSaberMais, String imagemLocal) {
        this.idLocal = idLocal;
        this.idTipoLocal = idTipoLocal;
        this.nomeLocal = nomeLocal;
        this.descricao = descricao;
        this.linkSaberMais = linkSaberMais;
        this.imagemLocal = imagemLocal;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public int getIdTipoLocal() {
        return idTipoLocal;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLinkSaberMais() {
        return linkSaberMais;
    }

    public String getImagemLocal() {
        return imagemLocal;
    }
}
