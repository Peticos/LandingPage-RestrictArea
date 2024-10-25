package com.peticos.Model;

public class Endereco {
    private int id_endereco;
    private String estado;
    private String cidade;
    private String bairro;

    public Endereco(int id_categoria, String estado, String cidade, String bairro) {
        this.id_endereco = id_categoria;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
    }

    public String getEstado() {
        return this.estado;
    }

    public int getId() {
        return this.id_endereco;
    }
    public String getCidade() {
        return this.cidade;
    }
    public String getBairro() {
        return this.bairro;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}