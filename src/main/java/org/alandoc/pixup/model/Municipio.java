package org.alandoc.pixup.model;

public class Municipio extends Catalogo
{
    private String nombre;
    public Estado estado;

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
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", estado=" + (estado != null ? estado.getNombre() : "Sin estado asignado") +
                '}';
    }
}
