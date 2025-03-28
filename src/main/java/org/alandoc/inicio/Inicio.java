package org.alandoc.inicio;

import org.alandoc.model.TipoEjecutable;
import org.alandoc.util.ReadUtil;
import org.alandoc.vista.Ejecutable;
import org.alandoc.vista.Menu;
import org.alandoc.vista.Ventana;


public class Inicio {

    public Inicio() {
    }

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            // Mostrar menú principal
            Menu.Menu4();
            int opcion = ReadUtil.readInt();

            // Obtener el tipo ejecutable
            TipoEjecutable tipoEjecutable = TipoEjecutable.getTipoEjecutableById(opcion);

            // Procesar opción seleccionada
            continuar = procesarOpcion(tipoEjecutable);
        }
    }

    private static boolean procesarOpcion(TipoEjecutable tipoEjecutable) {
        if (TipoEjecutable.SALIR.equals(tipoEjecutable)) {
            return false; // Detener programa
        }

        if (TipoEjecutable.OPCION_ERRONEA.equals(tipoEjecutable)) {
            Menu.opcionInvalida();
        } else if (tipoEjecutable.getEjecutable() != null) {
            Ejecutable ejecutable = tipoEjecutable.getEjecutable();
            ejecutable.run();
        }

        return true; // Continuar programa
    }


}