package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.model.GeneroMusical;
import org.alandoc.pixup.util.ReadUtil;

import java.io.File;

public class GeneroMusicalCatalogo extends Catalogos<GeneroMusical> {
    public static GeneroMusicalCatalogo generoMusicalCatalogo;

    private GeneroMusicalCatalogo() { super(); }

    public static GeneroMusicalCatalogo getInstance() {
        if (generoMusicalCatalogo == null) {
            generoMusicalCatalogo = new GeneroMusicalCatalogo();
        }
        return generoMusicalCatalogo;
    }

    @Override
    public GeneroMusical newT() { return new GeneroMusical(); }

    @Override
    public boolean processNewT(GeneroMusical generoMusical) {
        System.out.println("Teclee la descripción del género musical:");
        generoMusical.setDescripcion(ReadUtil.read());

        // Asignar ID y agregar el género musical a la lista
        generoMusical.setId(list.size() + 1);
        list.add(generoMusical);

        System.out.println("\nGénero musical registrado correctamente: " + generoMusical.getDescripcion());

        return true;
    }

    @Override
    public void processEditT(GeneroMusical generoMusical) {
        System.out.println("Id del Género Musical: " + generoMusical.getId());
        System.out.println("Género a editar: " + generoMusical.getDescripcion());
        System.out.println("Teclee la nueva descripción:");
        generoMusical.setDescripcion(ReadUtil.read());
    }

    @Override
    public void print() {
        System.out.println("Ejecutando impresión única...");
        if (isListEmpty()) {
            System.out.println("No hay géneros musicales registrados.");
        } else {
            list.forEach(System.out::println);
        }
    }

}