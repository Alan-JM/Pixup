package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.model.Estado;
import org.alandoc.pixup.model.Municipio;
import org.alandoc.pixup.util.ReadUtil;

import java.io.File;


public class MunicipioCatalogo extends Catalogos<Municipio>{
    public static MunicipioCatalogo municipioCatalogo;
    private MunicipioCatalogo( )
    {
        super();
    }

    public static MunicipioCatalogo getInstance( )
    {
        if(municipioCatalogo==null)
        {
            municipioCatalogo = new MunicipioCatalogo();
        }
        return municipioCatalogo;
    }

    @Override
    public Municipio newT()
    {
        return new Municipio( );
    }

    @Override
    public boolean processNewT(Municipio municipio) {
        System.out.println("Teclee un Municipio");
        municipio.setNombre(ReadUtil.read());

        // Verificar si hay estados registrados
        if (EstadoCatalogo.getInstance().isListEmpty()) {
            System.out.println("No hay estados registrados. No se puede agregar un municipio.");
            return false;
        }

        // Imprimir estados disponibles
        System.out.println("\nEstados disponibles:");
        EstadoCatalogo.getInstance().list.forEach(e -> System.out.println("ID: " + e.getId() + " - Nombre: " + e.getNombre()));

        // Pedir ID del estado
        System.out.println("\nIngrese el ID del estado al que pertenece este municipio:");
        int idEstado = ReadUtil.readInt();

        // Buscar el estado con el ID ingresado
        Estado estadoSeleccionado = EstadoCatalogo.getInstance().list.stream()
                .filter(e -> e.getId() == idEstado) // Cambié .equals() por ==
                .findFirst()
                .orElse(null);

        if (estadoSeleccionado == null) {
            System.out.println("ID incorrecto. Municipio no registrado.");
            return false;
        }

        // **Aquí debes colocar el código para asignar el estado**
        municipio.setEstado(estadoSeleccionado);

        // Asignar ID y agregar el municipio a la lista
        municipio.setId(list.size() + 1);
        list.add(municipio);

        System.out.println("\nMunicipio registrado correctamente en el estado: " + estadoSeleccionado.getNombre());

        return true;
    }





    @Override
    public void processEditT(Municipio municipio)
    {
        System.out.println("Id del Municipio " + municipio.getId( ) );
        System.out.println("Municipio a editar: " + municipio.getNombre( ) );
        System.out.println("Teclee el valor nuevo del Municipio" );
        municipio.setNombre( ReadUtil.read( ) );
    }


}
