package org.alandoc.model;

public enum TipoResumen {

        CATALOGO(1),
        PENDIENTE(2),
        SALIR(3),
        OPCION_ERRONEA(4);
        private Integer tipo;

    TipoResumen(Integer tipo) {
        this.tipo = tipo;
    }

    public static Localidad getTipoEstadosById() {
        return null;
    }

    public static TipoResumen getTipoResumenById() {

        return null;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public static TipoResumen getTipoResumenById(int id) {
        switch (id) {
            case 1:
                return CATALOGO;
            case 2:
                return PENDIENTE;
            case 3:
                return SALIR;
            case 4:
            default:
                return OPCION_ERRONEA;
        }
    }
}
