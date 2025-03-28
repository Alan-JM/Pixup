package org.alandoc.model;

public class Estado extends Localidad{

    protected Integer id;
    protected String nombre;

    public Estado() {
    }

    public Estado(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
