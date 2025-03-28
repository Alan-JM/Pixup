package org.alandoc.model;

public abstract class Localidad {
    protected Integer id;
    protected String nombre;

    public Localidad() {
    }
    /**
     * @return
     */
    public abstract Integer id( );

    /**
     * @return
     */
    public abstract String  nombre( );


}
