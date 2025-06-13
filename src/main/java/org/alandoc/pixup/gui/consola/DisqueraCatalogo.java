package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.model.Disquera;
import org.alandoc.pixup.util.ReadUtil;

<<<<<<< HEAD
public class DisqueraCatalogo extends CatalogosDisquera<Disquera>{
    public static DisqueraCatalogo disqueraCatalogo;
    private DisqueraCatalogo( )
    {
        super();
    }

    public static DisqueraCatalogo getInstance( )
    {
        if(disqueraCatalogo==null)
        {
=======
import java.io.File;

public class DisqueraCatalogo extends Catalogos<Disquera> {
    public static DisqueraCatalogo disqueraCatalogo;

    private DisqueraCatalogo() { super(); }

    public static DisqueraCatalogo getInstance() {
        if (disqueraCatalogo == null) {
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
            disqueraCatalogo = new DisqueraCatalogo();
        }
        return disqueraCatalogo;
    }

    @Override
<<<<<<< HEAD
    public Disquera newT() {
        return new Disquera();
    }

    @Override
    public boolean processNewT(Disquera disquera) {
        System.out.println("Teclee un Disquera" );
        disquera.setNombre( ReadUtil.read( ) );
=======
    public Disquera newT() { return new Disquera(); }

    @Override
    public boolean processNewT(Disquera disquera) {
        System.out.println("Teclee el nombre de la disquera:");
        disquera.setNombre(ReadUtil.read());

        // Asignar ID y agregar la disquera a la lista
        disquera.setId(list.size() + 1);
        list.add(disquera);

        System.out.println("\nDisquera registrada correctamente: " + disquera.getNombre());

>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
        return true;
    }

    @Override
    public void processEditT(Disquera disquera) {
<<<<<<< HEAD
        System.out.println("Id del disquera " + disquera.getId( ) );
        System.out.println("Disquera a editar: " + disquera.getNombre( ) );
        System.out.println("Teclee el valor nuevo del disquera" );
        disquera.setNombre( ReadUtil.read( ) );
    }

=======
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
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707

}