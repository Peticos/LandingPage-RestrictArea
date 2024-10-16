package com.peticos.Model;

public class Especie {
    private int id;
    private String especie;

    public Especie(int id, String especie) {
        this.id = id;
        this.especie = especie;
    }
    public int getId() {
        return id;
    }
    public String getNome() {
        return especie;
    }

}
