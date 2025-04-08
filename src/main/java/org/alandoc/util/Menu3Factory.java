package org.alandoc.util;

import org.alandoc.model.TipoLocalidad;
import org.alandoc.model.TipoResumen;

public class Menu3Factory {
    public static String getTipoResumenById(TipoResumen tipoResumen )
    {
        switch (tipoResumen)
        {
            case CATALOGO:
                return "Catalogo";
            case PENDIENTE:
                return "Pendiente";
            case OPCION_ERRONEA:
            case SALIR:
            default:
                return null;
        }
    }
}

