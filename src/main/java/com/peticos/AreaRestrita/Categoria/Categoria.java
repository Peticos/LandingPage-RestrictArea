package com.peticos.AreaRestrita.Categoria;

public class Categoria {
    private int id_categoria;
    private String nome;

    public Categoria(int id_categoria, String nome) {
        this.id_categoria = id_categoria;
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public int getId() {
        return this.id_categoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id_categoria=" + id_categoria +
                ", nome='" + nome + '\'' +
                '}';
    }
}