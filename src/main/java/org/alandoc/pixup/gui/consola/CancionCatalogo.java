package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.model.Cancion;
import org.alandoc.pixup.model.Disco;
import org.alandoc.pixup.util.ReadUtil;

import java.io.File;

public class CancionCatalogo extends Catalogos<Cancion> {
    public static CancionCatalogo cancionCatalogo;

    private CancionCatalogo() { super(); }

    public static CancionCatalogo getInstance() {
        if (cancionCatalogo == null) {
            cancionCatalogo = new CancionCatalogo();
        }
        return cancionCatalogo;
    }

    @Override
    public Cancion newT() { return new Cancion(); }

    @Override
    public boolean processNewT(Cancion cancion) {
        System.out.println("Teclee el título de la canción:");
        cancion.setTitulo(ReadUtil.read());

        System.out.println("Teclee la duración de la canción:");
        cancion.setDuracion(ReadUtil.read());

        if (DiscoCatalogo.getInstance().isListEmpty()) {
            System.out.println("No hay discos registrados. No se puede agregar una canción.");
            return false;
        }

        System.out.println("\nDiscos disponibles:");
        DiscoCatalogo.getInstance().list.forEach(d -> System.out.println("ID: " + d.getId() + " - Título: " + d.getTitulo()));

        System.out.println("\nIngrese el ID del disco al que pertenece esta canción:");
        int idDisco = ReadUtil.readInt();

        // Corrección en comparación de ID
        Disco discoSeleccionado = DiscoCatalogo.getInstance().list.stream()
                .filter(d -> d.getId() == idDisco) // <-- Cambio de .equals() a ==
                .findFirst()
                .orElse(null);

        if (discoSeleccionado == null) {
            System.out.println("ID incorrecto. Canción no registrada.");
            return false;
        }

        cancion.setDisco(discoSeleccionado);
        cancion.setId(list.size() + 1);
        list.add(cancion);

        System.out.println("\nCanción registrada correctamente en el disco: " + discoSeleccionado.getTitulo());

        return true;
    }

    @Override
    public void processEditT(Cancion cancion) {
        System.out.println("Id de la Canción: " + cancion.getId());
        System.out.println("Canción a editar: " + cancion.getTitulo());
        System.out.println("Teclee el nuevo título:");
        cancion.setTitulo(ReadUtil.read());

        System.out.println("Teclee la nueva duración:");
        cancion.setDuracion(ReadUtil.read());
    }

    @Override
    public void print() {
        System.out.println("Ejecutando impresión única...");
        System.out.println("Número de canciones registradas: " + list.size());

        if (isListEmpty()) {
            System.out.println("No hay canciones registradas.");
        } else {
            list.forEach(System.out::println);
        }
    }
}