
package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.dao.impl.DiscoDaoImpl;
import org.alandoc.pixup.model.Artista;
import org.alandoc.pixup.model.Cancion;
import org.alandoc.pixup.model.Disco;
import org.alandoc.pixup.util.ReadUtil;

import java.util.List;

public class CancionCatalogo extends CatalogosCancion<Cancion>{

    public static CancionCatalogo cancionCatalogo;
    private CancionCatalogo( )
    {
        super();
    }

    public static CancionCatalogo getInstance( )
    {
        if(cancionCatalogo==null)
        {
            cancionCatalogo = new CancionCatalogo();
        }
        return cancionCatalogo;
    }

    @Override
    public Cancion newT() {
        return new Cancion();
    }

    @Override
    public boolean processNewT(Cancion cancion) {
        System.out.println("Teclee una cancion" );
        cancion.setTitulo( ReadUtil.read( ) );
        cancion.setDuracion(ReadUtil.readSqlTime());

        List<Disco> discos = DiscoDaoImpl.getInstance().findAll();
        System.out.println("Seleccione un disco:");
        for (int i = 0; i < discos.size(); i++) {
            System.out.println((i + 1) + ". " + discos.get(i).getTitulo());
        }
        int opcionDisco = ReadUtil.readInt();
        if (opcionDisco >= 1 && opcionDisco <= discos.size()) {
            cancion.setDisco(discos.get(opcionDisco - 1));
        } else {
            System.out.println("Opción inválida. No se asignó disco.");
        }
        return true;
    }

    @Override
    public void processEditT(Cancion cancion) {
        System.out.println("Id del cancion " + cancion.getId( ) );


        System.out.println("Teclee el valor nuevo del artista" );
        cancion.setTitulo( ReadUtil.read( ) );
        System.out.println("Duracion nueva: " + cancion.getDuracion( ) );
        cancion.setDuracion( ReadUtil.readSqlTime( ) );

        List<Disco> discos = DiscoDaoImpl.getInstance().findAll();
        System.out.println("Seleccione otro disco:");
        for (int i = 0; i < discos.size(); i++) {
            System.out.println((i + 1) + ". " + discos.get(i).getTitulo());
        }
        int opcionDisco = ReadUtil.readInt();
        if (opcionDisco >= 1 && opcionDisco <= discos.size()) {
            cancion.setDisco(discos.get(opcionDisco - 1));
        } else {
            System.out.println("Opción inválida. No se asignó disco.");
        }

    }


}
