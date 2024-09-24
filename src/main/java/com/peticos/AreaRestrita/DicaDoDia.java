package com.peticos.AreaRestrita;

public class DicaDoDia {
    private int id;
    private String titulo;
    private String texto;
    private String link;
    private String data;

    public DicaDoDia(int id, String titulo, String texto, String link, String data) {
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

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "DicaDoDia{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                ", link='" + link + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
