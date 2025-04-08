package org.alandoc.util;

import org.alandoc.model.TipoEstados;
import org.alandoc.model.TipoLocalidad;

public class Menu2Factory {
    public static String getTipoLocalidadById(TipoLocalidad tipoLocalidad )
    {
        switch (tipoLocalidad)
        {
            case ESTADO:
                return "Estado";
            case MUNICIPIO:
                return "Municipio";
            case COLONIA:
                return "Colonia";
            case OPCION_ERRONEA:
            case SALIR:
            default:
                return null;
        }
    }
}
