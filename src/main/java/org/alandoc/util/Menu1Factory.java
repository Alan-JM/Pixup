package org.alandoc.util;

import org.alandoc.model.TipoEstados;
public class Menu1Factory
{

    public static String getTipoEstadosById(TipoEstados tipoEstados )
    {
        switch (tipoEstados)
        {
            case ALTA:
                return "Alta";
            case BAJA:
                return "Baja";
            case VER:
                return "Ver";
            case ACTUALIZAR:
                return "Actualizar";
            case OPCION_ERRONEA:
            case SALIR:
            default:
                return null;
        }
    }
}