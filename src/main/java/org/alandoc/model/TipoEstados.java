package org.alandoc.model;
import org.alandoc.vista.Consola;

public enum TipoEstados {
    ALTA(1),
    BAJA(2),
    VER(3),
    ACTUALIZAR(4),
    SALIR(5),
    OPCION_ERRONEA(6);
    private Integer tipo;

    TipoEstados(Integer tipo) {
        this.tipo = tipo;
    }

    public static Localidad getTipoEstadosById() {
        return null;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public static TipoEstados getTipoEstadosById(int id) {
        switch (id) {
            case 1:
                return ALTA;
            case 2:
                return BAJA;
            case 3:
                return VER;
            case 4:
                return ACTUALIZAR;
            case 5:
                return SALIR;
            case 6:
            default:
                return OPCION_ERRONEA;
        }
    }
}
