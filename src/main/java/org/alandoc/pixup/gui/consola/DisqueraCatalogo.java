package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.model.Disquera;
import org.alandoc.pixup.util.ReadUtil;

import java.io.File;

public class DisqueraCatalogo extends Catalogos<Disquera> {
    public static DisqueraCatalogo disqueraCatalogo;

    private DisqueraCatalogo() { super(); }

    public static DisqueraCatalogo getInstance() {
        if (disqueraCatalogo == null) {
            disqueraCatalogo = new DisqueraCatalogo();
        }
        return disqueraCatalogo;
    }

    @Override
    public Disquera newT() { return new Disquera(); }

    @Override
    public boolean processNewT(Disquera disquera) {
        System.out.println("Teclee el nombre de la disquera:");
        disquera.setNombre(ReadUtil.read());

        // Asignar ID y agregar la disquera a la lista
        disquera.setId(list.size() + 1);
        list.add(disquera);

        System.out.println("\nDisquera registrada correctamente: " + disquera.getNombre());

        return true;
    }

    @Override
    public void processEditT(Disquera disquera) {
        System.out.println("Id de la Disquera: " + disquera.getId());
        System.out.println("Disquera a editar: " + disquera.getNombre());
        System.out.println("Teclee el nuevo nombre:");
        disquera.setNombre(ReadUtil.read());
    }

    @Override
    public void print() {
        System.out.println("Ejecutando impresión única...");
        if (isListEmpty()) {
            System.out.println("No hay disqueras registradas.");
        } else {
            list.forEach(System.out::println);
        }
    }

    @Override
    public File getFile() {
        return new File("Disquera.list");
    }
}