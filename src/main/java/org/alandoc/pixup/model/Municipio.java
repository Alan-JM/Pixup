package org.alandoc.pixup.model;

public class Municipio extends Catalogo
{
    private String nombre;
    private Estado estado;

    public Municipio() {
    }

    public Municipio(String nombre, Estado estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEstado() {
        return id;
    }

    public void setEstado(Estado estado) {
        super.id = estado.getId();
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id + '\'' +
                ", estado=" + estado +
                '}';
    }
}
