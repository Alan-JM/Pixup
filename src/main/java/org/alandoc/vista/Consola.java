package org.alandoc.vista;

import org.alandoc.model.Localidad;
import org.alandoc.model.TipoEstados;
import org.alandoc.model.TipoLocalidad;
import org.alandoc.model.TipoResumen;
import org.alandoc.util.ReadUtil;

public class Consola implements Ejecutable {
    public String estados;
    private static Consola consola;

    private Consola() {
    }

    public static Consola getInstance() {
        if (consola == null) {
            return new Consola();
        }
        return consola;
    }

    @Override
    public void run() {

        boolean flag = true;
        int opcion = 0;
        int goout = 1;
        TipoEstados tipoEstados = null;
        TipoLocalidad tipoLocalidad = null;
        TipoResumen tipoResumen = null;
        Localidad localidad = null;

        Menu.Estado();
        estados = ReadUtil.read();


        while (flag) {
            Menu.Menu1();
            opcion = ReadUtil.readInt();

            tipoEstados = TipoEstados.getTipoEstadosById(opcion);

            if (TipoEstados.SALIR.equals(tipoEstados)) {
                goout = 0;
                flag = false;
            }
            if (TipoEstados.OPCION_ERRONEA.equals(tipoEstados)) {
                Menu.opcionInvalida();
            }

            localidad = TipoEstados.getTipoEstadosById();
            if (localidad != null) {
                ((SolicitaDatos) localidad).leeDatos();
                Menu.ingreosEstados(localidad);
                flag = false;
            }

if (goout == 0){
    flag = false;
}else {
    flag = true;
}

if (flag = true) {
                Menu.Menu2();
                opcion = ReadUtil.readInt();

                tipoLocalidad = TipoLocalidad.getTipoLocalidadById(opcion);

                if (TipoEstados.SALIR.equals(tipoLocalidad)) {
                    goout = 0;
                    flag = false;
                }
                if (TipoEstados.OPCION_ERRONEA.equals(tipoLocalidad)) {
                    Menu.opcionInvalida();
                }

                localidad = TipoLocalidad.getTipoEstadosById();
                if (localidad != null) {
                    ((SolicitaDatos) localidad).leeDatos();
                    Menu.ingreosEstados(localidad);

                }
}


            if (goout == 0){
                flag = false;
            }else {
                flag = true;
            }

if (flag = true) {
                Menu.Menu3();
                opcion = ReadUtil.readInt();

                tipoResumen = TipoResumen.getTipoResumenById();

                if (TipoLocalidad.SALIR.equals(tipoResumen)) {
                    goout = 0;
                    flag = false;
                }
                if (TipoLocalidad.OPCION_ERRONEA.equals(tipoResumen)) {
                    Menu.opcionInvalida();
                }
                tipoResumen = TipoResumen.getTipoResumenById();
                localidad = TipoResumen.getTipoEstadosById();
                if (localidad != null) {
                    ((SolicitaDatos) localidad).leeDatos();
                    Menu.ingresosLocalidad(localidad);
                    flag = false;

                }
}
    flag = false;


        }

    }

    }