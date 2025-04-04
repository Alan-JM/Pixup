package org.alandoc.pixup.model;

public class Cancion extends Catalogo {
    private String titulo;
    private String duracion;
    private Disco disco;

    public Cancion() {}

    public Cancion(String titulo, String duracion, Disco disco) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.disco = disco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "titulo='" + titulo + '\'' +
                ", duracion='" + duracion + '\'' +
                ", disco=" + (disco != null ? disco.getTitulo() : "Sin disco") +
                '}';
    }
}