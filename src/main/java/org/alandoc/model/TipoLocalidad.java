package org.alandoc.model;

public enum TipoLocalidad {
    ESTADO(1),
    MUNICIPIO(2),
    COLONIA(3),
    SALIR(4),
    OPCION_ERRONEA(5);
    private Integer tipo;

    TipoLocalidad(Integer tipo) {
        this.tipo = tipo;
    }

    public static Localidad getTipoEstadosById() {
        return null;
    }

    public static TipoLocalidad getTipoLocalidadById() {

        return null;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public static TipoLocalidad getTipoLocalidadById(int id) {
        switch (id) {
            case 1:
                return ESTADO;
            case 2:
                return MUNICIPIO;
            case 3:
                return COLONIA;
            case 4:
                return SALIR;
            case 5:
            default:
                return OPCION_ERRONEA;
        }
    }
}
