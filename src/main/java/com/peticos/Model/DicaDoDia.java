package com.peticos.Model;

import java.sql.Date;

public class DicaDoDia {
    private int id;
    private String titulo;
    private String texto;
    private String link;
    private Date data;

    public DicaDoDia(int id, String titulo, String texto, String link, Date data) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.link = link;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

    public String getLink() {
        return link;
    }

    public Date getData() {
        return data;
    }
    public String getFormatedData() {
        String data = this.data.toString();
        String ano = data.substring(0,4);
        String mes = data.substring(5,7);
        String dia = data.substring(8);
        return dia+"/"+mes+"/"+ano;
    }
}
