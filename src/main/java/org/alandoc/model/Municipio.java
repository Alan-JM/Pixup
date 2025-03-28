package org.alandoc.model;

public class Municipio extends Localidad{

    private Estado estado;

    public Municipio() {
    }


    public Municipio(Integer id, String nombre, Estado estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    @Override
    public Integer id() {
        return this.id;
    }

    @Override
    public String nombre() {
        return this.nombre;
    }
}
