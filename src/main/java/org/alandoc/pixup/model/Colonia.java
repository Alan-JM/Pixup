package org.alandoc.pixup.model;

public class Colonia extends  Catalogo{
    private String nombre;
    private String cp;
    public Municipio municipio;

    public Colonia() {
    }

    public Colonia(String nombre, String cp, Municipio municipio) {
        this.nombre = nombre;
        this.cp = cp;
        this.municipio = municipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return "Colonia{" +
                "nombre='" + nombre + '\'' +
                ", cp='" + cp + '\'' +
                ", municipio=" + (municipio != null ? municipio.getNombre() : "Sin municipio asignado") +
                '}';
    }
}
