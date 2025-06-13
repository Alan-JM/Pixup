
package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.dao.DisqueraDao;
import org.alandoc.pixup.dao.GeneroMusicalDao;
import org.alandoc.pixup.dao.impl.DisqueraDaoImpl;
import org.alandoc.pixup.dao.impl.GeneroMusicalDaoImpl;
import org.alandoc.pixup.gui.LecturaAccion;
import org.alandoc.pixup.model.Catalogo;
import org.alandoc.pixup.model.Disquera;
import org.alandoc.pixup.model.GeneroMusical;
import org.alandoc.pixup.util.ReadUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class CatalogosGeneroMusical<T extends Catalogo> extends LecturaAccion {

    protected List<T> list;
    protected T t;
    protected boolean flag2;

    public CatalogosGeneroMusical() {
        list = new ArrayList<>();
    }

    public boolean isListEmpty() {
        return list.isEmpty();
    }


    public abstract GeneroMusical newT();

    public abstract boolean processNewT(GeneroMusical generoMusical);

    public abstract void processEditT(GeneroMusical generoMusical);

    public void print() {
        GeneroMusicalDao generoMusicalDao = GeneroMusicalDaoImpl.getInstance(); //  Conexión con BD
        List<GeneroMusical> generoMusicals = generoMusicalDao.findAll(); //  Recuperando datos desde MySQL

        if (generoMusicals == null || generoMusicals.isEmpty()) {
            System.out.println(" No hay generos musicales guardados en la base de datos.");
        } else {
            System.out.println("Lista de generos musicales guardados:");
            generoMusicals.forEach(generoMusical -> System.out.println("- " + generoMusical.getId() + ": " + generoMusical.getNombre()));
        }
    }



    public void add() {
        GeneroMusicalDao generoMusicalDao = GeneroMusicalDaoImpl.getInstance();
        GeneroMusical generoMusical = new GeneroMusical();
        System.out.println("Ingrese el nombre del nuevo genero musical:");
        generoMusical.setNombre(ReadUtil.read()); //  Captura entrada del usuario

        System.out.println(" Genero musical a insertar: " + generoMusical.getNombre()); //  Depuración

        boolean res = generoMusicalDao.save(generoMusical); //  Guarda en BD
        if (res) {
            System.out.println(" Genero musical guardado correctamente.");
        } else {
            System.out.println(" Error al guardar el genero musical.");
        }

    }
    public void edit() {
        GeneroMusicalDao generoMusicalDao = GeneroMusicalDaoImpl.getInstance();
        List<GeneroMusical> generoMusicals = generoMusicalDao.findAll(); // Recuperando datos desde la BD

        if (generoMusicals == null || generoMusicals.isEmpty()) {
            System.out.println("No hay elementos para editar.");
            return;
        }

        flag2 = true;
        while (flag2) {
            System.out.println("Ingrese el ID del elemento a editar:");
            print(); // Muestra los artistas disponibles

            int idBuscado;
            try {
                idBuscado = ReadUtil.readInt();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Ingresa un número entero.");
                continue;
            }

            // Buscar la disquera en la base de datos
            GeneroMusical generoMusical = generoMusicals.stream()
                    .filter(e -> e.getId() != null && e.getId().equals(idBuscado))
                    .findFirst()
                    .orElse(null);

            if (generoMusical == null) {
                System.out.println("ID incorrecto, intenta nuevamente.");
            } else {
                System.out.println("Ingrese el nuevo nombre del genero musical:");
                String nuevoNombre = ReadUtil.read(); // Captura el nuevo nombre

                if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                    generoMusical.setNombre(nuevoNombre); // Solo modifica si hay entrada válida
                    boolean actualizado = generoMusicalDao.update(generoMusical); // Guarda cambios en BD

                    if (actualizado) {
                        System.out.println("Elemento modificado y guardado en la BD.");
                    } else {
                        System.out.println("Error al guardar los cambios en la BD.");
                    }
                } else {
                    System.out.println("No se ingresó un nuevo nombre. La edición fue cancelada.");
                }

                flag2 = false;
            }
        }
    }
    private void processEditT(T disquera) {

    }


    public void remove() {
        GeneroMusicalDao generoMusicalDao = GeneroMusicalDaoImpl.getInstance();
        List<GeneroMusical> generoMusicals = generoMusicalDao.findAll(); // Recuperando datos desde la BD

        if (generoMusicals == null || generoMusicals.isEmpty()) {
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

            GeneroMusical generoMusical = generoMusicals.stream()
                    .filter(e -> e.getId() != null && e.getId().equals(idBuscado))
                    .findFirst()
                    .orElse(null);

            if (generoMusical == null) {
                System.out.println("ID incorrecto, intenta nuevamente.");
            } else {
                boolean eliminado = generoMusicalDao.delete(generoMusical); // Llama al metodo que borra la BD

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
        System.out.println("Menú Genero Musical");
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
