package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.model.Colonia;
import org.alandoc.pixup.model.Municipio;
import org.alandoc.pixup.util.ReadUtil;

import java.io.File;

public class ColoniaCatalogo extends Catalogos<Colonia> {
    public static ColoniaCatalogo coloniaCatalogo;

    private ColoniaCatalogo() {
        super();
    }

    public static ColoniaCatalogo getInstance() {
        if (coloniaCatalogo == null) {
            coloniaCatalogo = new ColoniaCatalogo();
        }
        return coloniaCatalogo;
    }

    @Override
    public Colonia newT() {
        return new Colonia();
    }

    @Override
    public boolean processNewT(Colonia colonia) {
        System.out.println("Teclee el nombre de la colonia:");
        colonia.setNombre(ReadUtil.read());

        System.out.println("Teclee el código postal:");
        colonia.setCp(ReadUtil.read());

        // Verificar si hay municipios registrados
        if (MunicipioCatalogo.getInstance().isListEmpty()) {
            System.out.println("No hay municipios registrados. No se puede agregar una colonia.");
            return false;
        }

        // Imprimir municipios disponibles
        System.out.println("\nMunicipios disponibles:");
        MunicipioCatalogo.getInstance().list.forEach(m -> System.out.println("ID: " + m.getId() + " - Nombre: " + m.getNombre()));

        // Pedir ID del municipio
        System.out.println("\nIngrese el ID del municipio al que pertenece esta colonia:");
        int idMunicipio = ReadUtil.readInt();

        // Buscar el municipio con el ID ingresado
        Municipio municipioSeleccionado = MunicipioCatalogo.getInstance().list.stream()
                .filter(m -> m.getId().equals(idMunicipio))
                .findFirst()
                .orElse(null);

        if (municipioSeleccionado == null) {
            System.out.println("ID incorrecto. Colonia no registrada.");
            return false;
        }

        // Asignar el municipio a la colonia
        colonia.setMunicipio(municipioSeleccionado);

        // Asignar ID y agregar la colonia a la lista
        colonia.setId(list.size() + 1);
        list.add(colonia);

        System.out.println("\nColonia registrada correctamente en el municipio: " + municipioSeleccionado.getNombre());

        return true;
    }

    @Override
    public void processEditT(Colonia colonia) {
        System.out.println("Id de la Colonia: " + colonia.getId());
        System.out.println("Colonia a editar: " + colonia.getNombre());
        System.out.println("Teclee el nuevo nombre:");
        colonia.setNombre(ReadUtil.read());

        System.out.println("Teclee el nuevo código postal:");
        colonia.setCp(ReadUtil.read());
    }

    @Override
    public void print() {
        System.out.println("Ejecutando impresión única...");
        if (isListEmpty()) {
            System.out.println("No hay colonias registradas.");
        } else {
            list.forEach(System.out::println);
        }
    }

    @Override
    public File getFile() {
        return new File("colonia.list");
    }
}