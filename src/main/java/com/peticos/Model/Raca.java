package com.peticos.Model;

public class Raca {
    // Atributos do banco
    private String raca;
    private int idRaca;

    public Raca( int idRaca, String raca) {
        this.raca = raca;
        this.idRaca = idRaca;
    }
    public String getRaca() {
        return this.raca;
    }
    public int getId_raca() {
        return this.idRaca;
    }
}
