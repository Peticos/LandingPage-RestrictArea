package com.peticos.AreaRestrita.Categoria;

public class Categoria {
    private int id_categoria;
    private String nome;

    public Categoria(int id_categoria, String nome) {
        this.id_categoria = id_categoria;
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_categoria() {
        return this.id_categoria;
    }
}
