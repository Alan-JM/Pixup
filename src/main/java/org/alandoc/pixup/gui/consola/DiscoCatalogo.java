package org.alandoc.pixup.gui.consola;

<<<<<<< HEAD
import org.alandoc.pixup.dao.impl.ArtistaDaoImpl;
import org.alandoc.pixup.dao.impl.DisqueraDaoImpl;
import org.alandoc.pixup.dao.impl.GeneroMusicalDaoImpl;
import org.alandoc.pixup.model.Artista;
import org.alandoc.pixup.model.Disco;
import org.alandoc.pixup.model.Disquera;
import org.alandoc.pixup.model.GeneroMusical;
import org.alandoc.pixup.util.ReadUtil;

import java.util.List;

public class DiscoCatalogo extends CatalogosDisco<Disco>{

    public static DiscoCatalogo discoCatalogo;
    private DiscoCatalogo( )
    {
        super();
    }

    public static DiscoCatalogo getInstance( )
    {
        if(discoCatalogo==null)
        {
=======
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
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
            discoCatalogo = new DiscoCatalogo();
        }
        return discoCatalogo;
    }

<<<<<<< HEAD

    @Override
    public Disco newT() {
        return new Disco();
    }

    @Override
    public boolean processNewT(Disco disco) {
        System.out.println("Teclee un Titulo de un Disco" );
        disco.setTitulo( ReadUtil.read( ) );
        System.out.println("Teclee un Precio de un Disco" );
        disco.setPrecio( ReadUtil.readFloat( ) );
        System.out.println("Teclee un Existencia de un Disco" );
        disco.setExistencia( ReadUtil.readInt( ) );
        System.out.println("Teclee un Descuento de un Disco" );
        disco.setDescuento( ReadUtil.readFloat( ) );
        System.out.println("Teclee una Fecha de lanzamiento de un Disco" );
        disco.setFechaLanzamiento( ReadUtil.readDate( ) );
        System.out.println("Teclee una Imagen de un Disco" );
        disco.setImagen( ReadUtil.read( ) );

        // Obtener listas de entidades foráneas
        List<Artista> artistas = ArtistaDaoImpl.getInstance().findAll();
        List<Disquera> disqueras = DisqueraDaoImpl.getInstance().findAll();
        List<GeneroMusical> generos = GeneroMusicalDaoImpl.getInstance().findAll();

// Seleccionar artista
        System.out.println("Seleccione un artista:");
        for (int i = 0; i < artistas.size(); i++) {
            System.out.println((i + 1) + ". " + artistas.get(i).getNombre());
        }
        int opcionArtista = ReadUtil.readInt();
        disco.setArtista(artistas.get(opcionArtista - 1));

// Seleccionar disquera
        System.out.println("Seleccione una disquera:");
        for (int i = 0; i < disqueras.size(); i++) {
            System.out.println((i + 1) + ". " + disqueras.get(i).getNombre());
        }
        int opcionDisquera = ReadUtil.readInt();
        disco.setDisquera(disqueras.get(opcionDisquera - 1));

// Seleccionar género musical
        System.out.println("Seleccione un género musical:");
        for (int i = 0; i < generos.size(); i++) {
            System.out.println((i + 1) + ". " + generos.get(i).getNombre());
        }
        int opcionGenero = ReadUtil.readInt();
        disco.setGeneroMusical(generos.get(opcionGenero - 1));
=======
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

>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
        return true;
    }

    @Override
    public void processEditT(Disco disco) {
<<<<<<< HEAD
        System.out.println("Id del disco " + disco.getId( ) );


        System.out.println("Artista a editar: " + disco.getTitulo()+ ":" + disco.getPrecio() +": "+ disco.getExistencia()+": "+disco.getDescuento()+": "+disco.getFechaLanzamiento()+": "+disco.getImagen()+": "+disco.getDisquera()+": "+disco.getArtista()+": "+disco.getGeneroMusical());
        System.out.println("Teclee el valor nuevo del artista" );
        disco.setTitulo( ReadUtil.read( ) );
        System.out.println("Teclee un nuevo Precio de un Disco" );
        disco.setPrecio( ReadUtil.readFloat( ) );
        System.out.println("Teclee nuevos Existencias de un Disco" );
        disco.setExistencia( ReadUtil.readInt( ) );
        System.out.println("Teclee un nuevo Descuento de un Disco" );
        disco.setDescuento( ReadUtil.readFloat( ) );
        System.out.println("Teclee una nueva Fecha de lanzamiento de un Disco" );
        disco.setFechaLanzamiento( ReadUtil.readDate( ) );
        System.out.println("Teclee una nueva Imagen de un Disco" );
        disco.setImagen( ReadUtil.read( ) );

        // Obtener listas de entidades foráneas
        List<Artista> artistas = ArtistaDaoImpl.getInstance().findAll();
        List<Disquera> disqueras = DisqueraDaoImpl.getInstance().findAll();
        List<GeneroMusical> generos = GeneroMusicalDaoImpl.getInstance().findAll();

// Seleccionar artista
        System.out.println("Seleccione otro artista:");
        for (int i = 0; i < artistas.size(); i++) {
            System.out.println((i + 1) + ". " + artistas.get(i).getNombre());
        }
        int opcionArtista = ReadUtil.readInt();
        disco.setArtista(artistas.get(opcionArtista - 1));

// Seleccionar disquera
        System.out.println("Seleccione otro disquera:");
        for (int i = 0; i < disqueras.size(); i++) {
            System.out.println((i + 1) + ". " + disqueras.get(i).getNombre());
        }
        int opcionDisquera = ReadUtil.readInt();
        disco.setDisquera(disqueras.get(opcionDisquera - 1));

// Seleccionar género musical
        System.out.println("Seleccione otro género musical:");
        for (int i = 0; i < generos.size(); i++) {
            System.out.println((i + 1) + ". " + generos.get(i).getNombre());
        }
        int opcionGenero = ReadUtil.readInt();
        disco.setGeneroMusical(generos.get(opcionGenero - 1));
    }


}
=======
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
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
