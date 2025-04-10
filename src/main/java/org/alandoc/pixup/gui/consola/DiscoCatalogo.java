package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.model.Disco;
import org.alandoc.pixup.model.Disquera;
import org.alandoc.pixup.model.Artista;
import org.alandoc.pixup.model.GeneroMusical;
import org.alandoc.pixup.util.ReadUtil;

import java.io.File;

public class DiscoCatalogo extends Catalogos<Disco> {
    public static DiscoCatalogo discoCatalogo;

    private DiscoCatalogo() { super(); }

    public static DiscoCatalogo getInstance() {
        if (discoCatalogo == null) {
            discoCatalogo = new DiscoCatalogo();
        }
        return discoCatalogo;
    }

    @Override
    public Disco newT() { return new Disco(); }

    @Override
    public boolean processNewT(Disco disco) {
        System.out.println("Teclee el título del disco:");
        disco.setTitulo(ReadUtil.read());

        System.out.println("Teclee el precio del disco:");
        disco.setPrecio(Float.parseFloat(ReadUtil.read()));

        System.out.println("Teclee la existencia del disco:");
        disco.setExistencia(ReadUtil.readInt());

        System.out.println("Teclee el descuento del disco:");
        disco.setDescuento(Float.parseFloat(ReadUtil.read()));

        System.out.println("Teclee la fecha de lanzamiento:");
        disco.setFechaLanzamiento(ReadUtil.read());

        System.out.println("Teclee la imagen (ruta o URL):");
        disco.setImagen(ReadUtil.read());

        // Verificar si hay disqueras registradas
        if (DisqueraCatalogo.getInstance().isListEmpty()) {
            System.out.println("No hay disqueras registradas. No se puede agregar un disco.");
            return false;
        }

        // Pedir ID de la disquera
        System.out.println("\nIngrese el ID de la disquera:");
        int idDisquera = ReadUtil.readInt();
        Disquera disqueraSeleccionada = DisqueraCatalogo.getInstance().list.stream()
                .filter(d -> d.getId() == idDisquera) // Corrección aquí
                .findFirst()
                .orElse(null);

        if (disqueraSeleccionada == null) {
            System.out.println("ID incorrecto. Disco no registrado.");
            return false;
        }

        disco.setDisquera(disqueraSeleccionada);
        disco.setId(list.size() + 1);
        list.add(disco);

        System.out.println("\nDisco registrado correctamente en la disquera: " + disqueraSeleccionada.getNombre());

        return true;
    }

    @Override
    public void processEditT(Disco disco) {
        System.out.println("Id del Disco: " + disco.getId());
        System.out.println("Disco a editar: " + disco.getTitulo());
        System.out.println("Teclee el nuevo título:");
        disco.setTitulo(ReadUtil.read());

        System.out.println("Teclee el nuevo precio:");
        disco.setPrecio(Float.parseFloat(ReadUtil.read()));
    }

    @Override
    public void print() {
        System.out.println("Ejecutando impresión única...");
        if (isListEmpty()) {
            System.out.println("No hay discos registrados.");
        } else {
            list.forEach(System.out::println);
        }
    }
}