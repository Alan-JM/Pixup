package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.dao.ArtistaDao;
import org.alandoc.pixup.dao.DiscoDao;
import org.alandoc.pixup.dao.impl.ArtistaDaoImpl;
import org.alandoc.pixup.dao.impl.DiscoDaoImpl;
import org.alandoc.pixup.dao.impl.DisqueraDaoImpl;
import org.alandoc.pixup.dao.impl.GeneroMusicalDaoImpl;
import org.alandoc.pixup.gui.LecturaAccion;
import org.alandoc.pixup.model.*;
import org.alandoc.pixup.util.ReadUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class CatalogosDisco<T extends Catalogo> extends LecturaAccion {
    protected List<T> list;
    protected T t;
    protected boolean flag2;

    public CatalogosDisco() {
        list = new ArrayList<>();
    }

    public boolean isListEmpty() {
        return list.isEmpty();
    }

    public void print() {
        DiscoDao discoDao = DiscoDaoImpl.getInstance(); //  Conexión con BD
        List<Disco> discos = discoDao.findAll(); //  Recuperando datos desde MySQL

        if (discos == null || discos.isEmpty()) {
            System.out.println(" No hay discos guardados en la base de datos.");
        } else {
            System.out.println("Lista de discos guardados:");
            discos.forEach(disco -> System.out.println("Id " + disco.getId() + "Titulo: " + disco.getTitulo()+ "Precio: " + disco.getPrecio() +"Existencias: "+ disco.getExistencia()+"Descuento: "+disco.getDescuento()+"Fecha de lanzamiento: "+disco.getFechaLanzamiento()+"Imagen: "+disco.getImagen()+": "+disco.getDisquera()+": "+disco.getArtista()+": "+disco.getGeneroMusical()));
        }
    }

    public abstract T newT();
    public abstract boolean processNewT(T t);
    public abstract void processEditT(T t);

    public void add() {
        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        Disco disco = new Disco();

        //Titulo
        System.out.println("Ingrese el titulo del nuevo disco:");
        disco.setTitulo(ReadUtil.read()); //  Captura entrada del usuario
        System.out.println(" Titulo a insertar: " + disco.getTitulo()); //  Depuración

        //precio Float 00.00
        System.out.println("Ingrese el precio del nuevo disco:");
        disco.setPrecio(ReadUtil.readFloat()); //  Captura entrada del usuario
        System.out.println(" Precio a insertar: " + disco.getPrecio()); //  Depuración

        //existencia INT
        System.out.println("Ingrese el numero de existencias del disco:");
        disco.setExistencia(ReadUtil.readInt()); //  Captura entrada del usuario
        System.out.println(" Existencias a insertar: " + disco.getExistencia()); //  Depuración

        //descuento FLOAT 00.00
        System.out.println("Ingrese el descuento del nuevo disco:");
        disco.setDescuento(ReadUtil.readFloat()); //  Captura entrada del usuario
        System.out.println(" Descuento a insertar: " + disco.getDescuento()); //  Depuración
        //fechaLanzamiento DATE
        System.out.println("Ingrese el dia de lanzamiento del nuevo disco:");
        disco.setFechaLanzamiento(ReadUtil.readDate()); //  Captura entrada del usuario
        System.out.println(" Dia a insertar: " + disco.getFechaLanzamiento()); //  Depuración
        //imagen String
        System.out.println("Ingrese la imagen del nuevo disco:");
        disco.setImagen(ReadUtil.read()); //  Captura entrada del usuario
        System.out.println(" Dia a insertar: " + disco.getImagen()); //  Depuración


        List<Artista> artistas = ArtistaDaoImpl.getInstance().findAll();
        List<Disquera> disqueras = DisqueraDaoImpl.getInstance().findAll();
        List<GeneroMusical> generos = GeneroMusicalDaoImpl.getInstance().findAll();


// Mostrar artistas
        System.out.println("Seleccione el artista:");
        for (int i = 0; i < artistas.size(); i++) {
            System.out.println((i + 1) + ". " + artistas.get(i).getNombre());
        }
        int opcionArtista = ReadUtil.readInt();
        disco.setArtista(artistas.get(opcionArtista - 1));

// Disqueras
        System.out.println("Seleccione la disquera:");
        for (int i = 0; i < disqueras.size(); i++) {
            System.out.println((i + 1) + ". " + disqueras.get(i).getNombre());
        }
        int opcionDisquera = ReadUtil.readInt();
        disco.setDisquera(disqueras.get(opcionDisquera - 1));

// Géneros
        System.out.println("Seleccione el género musical:");
        for (int i = 0; i < generos.size(); i++) {
            System.out.println((i + 1) + ". " + generos.get(i).getNombre());
        }
        int opcionGenero = ReadUtil.readInt();
        disco.setGeneroMusical(generos.get(opcionGenero - 1));


        boolean res = discoDao.save(disco); //  Guarda en BD
        if (res) {
            System.out.println(" Disco guardado correctamente.");
        } else {
            System.out.println(" Error al guardar el titulo del disco.");
        }
    }
    public void edit() {
        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        List<Disco> discos = discoDao.findAll(); // Recuperando datos desde la BD

        if (discos == null || discos.isEmpty()) {
            System.out.println("No hay elementos para editar.");
            return;
        }

        flag2 = true;
        while (flag2) {
            System.out.println("Ingrese el ID del elemento a editar:");
            print(); // Muestra los artistas disponibles

            int idBuscado;
            try {
                idBuscado = ReadUtil.readInt(); // Captura un número entero
            } catch (Exception e) {
                System.out.println("Entrada no válida. Ingresa un número entero.");
                continue;
            }

            Disco disco = discos.stream()
                    .filter(e -> e.getId() != null && e.getId().equals(idBuscado))
                    .findFirst()
                    .orElse(null);

            if (disco == null) {
                System.out.println("ID incorrecto, intenta nuevamente.");
            } else {
                System.out.println("Ingrese el nuevo título del disco:");
                String nuevoTitulo = ReadUtil.read();
                if (nuevoTitulo != null && !nuevoTitulo.trim().isEmpty()) {
                    disco.setTitulo(nuevoTitulo);
                }

                System.out.println("Ingrese el nuevo precio del disco:");
                Float nuevoPrecio = ReadUtil.readFloat();
                if (nuevoPrecio != null) {
                    disco.setPrecio(nuevoPrecio);
                }

                System.out.println("Ingrese las nuevas existencias del disco:");
                Integer nuevaExistencia = ReadUtil.readInt();
                if (nuevaExistencia != null) {
                    disco.setExistencia(nuevaExistencia);
                }

                System.out.println("Ingrese el nuevo descuento del disco:");
                Float nuevoDescuento = ReadUtil.readFloat();
                if (nuevoDescuento != null) {
                    disco.setDescuento(nuevoDescuento);
                }

                System.out.println("Ingrese la nueva fecha de lanzamiento del disco:");
                java.sql.Date nuevaFecha = ReadUtil.readDate();
                if (nuevaFecha != null) {
                    disco.setFechaLanzamiento(nuevaFecha);
                }

                System.out.println("Ingrese la nueva imagen del disco:");
                String nuevaImagen = ReadUtil.read();
                if (nuevaImagen != null && !nuevaImagen.trim().isEmpty()) {
                    disco.setImagen(nuevaImagen);
                }

                List<Artista> artistas = ArtistaDaoImpl.getInstance().findAll();
                List<Disquera> disqueras = DisqueraDaoImpl.getInstance().findAll();
                List<GeneroMusical> generos = GeneroMusicalDaoImpl.getInstance().findAll();

                System.out.println("Seleccione el nuevo artista:");
                for (int i = 0; i < artistas.size(); i++) {
                    System.out.println((i + 1) + ". " + artistas.get(i).getNombre());
                }
                disco.setArtista(artistas.get(ReadUtil.readInt() - 1));

                System.out.println("Seleccione la nueva disquera:");
                for (int i = 0; i < disqueras.size(); i++) {
                    System.out.println((i + 1) + ". " + disqueras.get(i).getNombre());
                }
                disco.setDisquera(disqueras.get(ReadUtil.readInt() - 1));

                System.out.println("Seleccione el nuevo género musical:");
                for (int i = 0; i < generos.size(); i++) {
                    System.out.println((i + 1) + ". " + generos.get(i).getNombre());
                }
                disco.setGeneroMusical(generos.get(ReadUtil.readInt() - 1));

                boolean actualizado = discoDao.update(disco);
                if (actualizado) {
                    System.out.println("Elemento modificado y guardado en la BD.");
                } else {
                    System.out.println("Error al guardar los cambios en la BD.");
                }

                flag2 = false;
            }
        }
    }
    public void remove() {
        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        List<Disco> discos = discoDao.findAll(); // Recuperando datos desde la BD

        if (discos == null || discos.isEmpty()) {
            System.out.println("No hay elementos para borrar.");
            return;
        }

        flag2 = true;
        while (flag2) {
            System.out.println("Ingrese el ID del elemento a borrar:");
            print(); // Muestra los artistas disponibles

            int idBuscado;
            try {
                idBuscado = ReadUtil.readInt(); // Captura un número entero
            } catch (Exception e) {
                System.out.println("Entrada no válida. Ingresa un número entero.");
                continue;
            }

            Disco disco = discos.stream()
                    .filter(e -> e.getId() != null && e.getId().equals(idBuscado))
                    .findFirst()
                    .orElse(null);

            if (disco == null) {
                System.out.println("ID incorrecto, intenta nuevamente.");
            } else {
                boolean eliminado = discoDao.delete(disco); // Llama al metodo que borra en BD

                if (eliminado) {
                    System.out.println("Elemento eliminado correctamente.");
                } else {
                    System.out.println("Error al eliminar el elemento de la BD.");
                }

                flag2 = false;
            }
        }
    }

    @Override
    public void procesaOpcion() {
        switch (opcion) {
            case 1:
                add();
                break;
            case 2:
                edit();
                break;
            case 3:
                remove();
                break;
            case 4:
                print();
                break;
        }
    }

    @Override
    public void despliegaMenu() {
        System.out.println("Menú Disco");
        System.out.println("Seleccione una opción:");
        System.out.println("1.- Agregar");
        System.out.println("2.- Editar");
        System.out.println("3.- Borrar");
        System.out.println("4.- Imprimir estados guardados en BD");
        System.out.println("5.- Salir");
    }

    @Override
    public int valorMinMenu() {
        return 1;
    }

    @Override
    public int valorMaxMenu() {
        return 5;
    }

}
