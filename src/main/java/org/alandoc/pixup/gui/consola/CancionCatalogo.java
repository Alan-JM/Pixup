package org.alandoc.pixup.gui.consola;

<<<<<<< HEAD
import org.alandoc.pixup.dao.impl.DiscoDaoImpl;
import org.alandoc.pixup.model.Artista;
=======
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
import org.alandoc.pixup.model.Cancion;
import org.alandoc.pixup.model.Disco;
import org.alandoc.pixup.util.ReadUtil;

<<<<<<< HEAD
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
=======
import java.io.File;

public class CancionCatalogo extends Catalogos<Cancion> {
    public static CancionCatalogo cancionCatalogo;

    private CancionCatalogo() { super(); }

    public static CancionCatalogo getInstance() {
        if (cancionCatalogo == null) {
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
            cancionCatalogo = new CancionCatalogo();
        }
        return cancionCatalogo;
    }

    @Override
<<<<<<< HEAD
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
=======
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

>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
        return true;
    }

    @Override
    public void processEditT(Cancion cancion) {
<<<<<<< HEAD
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
=======
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
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
