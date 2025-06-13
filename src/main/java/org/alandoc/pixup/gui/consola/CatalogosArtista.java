package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.dao.ArtistaDao;
import org.alandoc.pixup.dao.impl.ArtistaDaoImpl;
import org.alandoc.pixup.gui.LecturaAccion;
import org.alandoc.pixup.model.Artista;
import org.alandoc.pixup.model.Catalogo;
import org.alandoc.pixup.util.ReadUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class CatalogosArtista<T extends Catalogo> extends LecturaAccion {
    protected List<T> list;
    protected T t;
    protected boolean flag2;

    public CatalogosArtista() {
        list = new ArrayList<>();
    }

    public boolean isListEmpty() {
        return list.isEmpty();
    }

    public void print() {
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance(); //  Conexión con BD
        List<Artista> artistas = artistaDao.findAll(); //  Recuperando datos desde MySQL

        if (artistas == null || artistas.isEmpty()) {
            System.out.println(" No hay artistas guardados en la base de datos.");
        } else {
            System.out.println("Lista de artistas guardados:");
            artistas.forEach(artista -> System.out.println("- " + artista.getId() + ": " + artista.getNombre()));
        }
    }

    public abstract T newT();
    public abstract boolean processNewT(T t);
    public abstract void processEditT(T t);

    public void add() {
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        Artista artista = new Artista();
        System.out.println("Ingrese el nombre del nuevo artista:");
        artista.setNombre(ReadUtil.read()); //  Captura entrada del usuario

        System.out.println(" Artista a insertar: " + artista.getNombre()); //  Depuración

        boolean res = artistaDao.save(artista); //  Guarda en BD
        if (res) {
            System.out.println(" Artista guardado correctamente.");
        } else {
            System.out.println(" Error al guardar el artista.");
        }
    }
    public void edit() {
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        List<Artista> artistas = artistaDao.findAll(); // Recuperando datos desde la BD

        if (artistas == null || artistas.isEmpty()) {
            System.out.println("No hay elementos para editar.");
            return;
        }

        flag2 = true;
        while (flag2) {
            System.out.println("Ingrese el ID del elemento a editar:");
            print(); // Muestra los artistas disponibles

            int idBuscado;
            try {
                idBuscado = ReadUtil.readInt(); // Captura un entero
            } catch (Exception e) {
                System.out.println("Entrada no válida. Ingresa un número entero.");
                continue;
            }

            // Buscar el artista en la base de datos
            Artista artista = artistas.stream()
                    .filter(e -> e.getId() != null && e.getId().equals(idBuscado))
                    .findFirst()
                    .orElse(null);

            if (artista == null) {
                System.out.println("ID incorrecto, intenta nuevamente.");
            } else {
                processEditT((T) artista); // Edita el objeto
                boolean actualizado = artistaDao.update(artista); // Guarda cambios en BD

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
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        List<Artista> artistas = artistaDao.findAll(); // Recuperando datos desde la BD

        if (artistas == null || artistas.isEmpty()) {
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

            Artista artista = artistas.stream()
                    .filter(e -> e.getId() != null && e.getId().equals(idBuscado))
                    .findFirst()
                    .orElse(null);

            if (artista == null) {
                System.out.println("ID incorrecto, intenta nuevamente.");
            } else {
                boolean eliminado = artistaDao.delete(artista); // Llama al método que borra en BD

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
        System.out.println("Menú Artista");
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