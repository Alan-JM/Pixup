
package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.dao.DisqueraDao;
import org.alandoc.pixup.dao.impl.DisqueraDaoImpl;
import org.alandoc.pixup.gui.LecturaAccion;
import org.alandoc.pixup.model.Catalogo;
import org.alandoc.pixup.model.Disquera;
import org.alandoc.pixup.util.ReadUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class CatalogosDisquera<T extends Catalogo> extends LecturaAccion {

    protected List<T> list;
    protected T t;
    protected boolean flag2;

    public CatalogosDisquera() {
        list = new ArrayList<>();
    }

    public boolean isListEmpty() {
        return list.isEmpty();
    }


    public abstract Disquera newT();

    public abstract boolean processNewT(Disquera disquera);

    public abstract void processEditT(Disquera disquera);

    public void print() {
        DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance(); //  Conexión con BD
        List<Disquera> disqueras = disqueraDao.findAll(); //  Recuperando datos desde MySQL

        if (disqueras == null || disqueras.isEmpty()) {
            System.out.println(" No hay disqueras guardados en la base de datos.");
        } else {
            System.out.println("Lista de disqueras guardados:");
            disqueras.forEach(disquera -> System.out.println("- " + disquera.getId() + ": " + disquera.getNombre()));
        }
    }



    public void add() {
        DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance();
        Disquera disquera = new Disquera();
        System.out.println("Ingrese el nombre de la nueva disquera:");
        disquera.setNombre(ReadUtil.read()); //  Captura entrada del usuario

        System.out.println(" Disquera a insertar: " + disquera.getNombre()); //  Depuración

        boolean res = disqueraDao.save(disquera); //  Guarda en BD
        if (res) {
            System.out.println(" Disquera guardado correctamente.");
        } else {
            System.out.println(" Error al guardar el disquera.");
        }
    }
    public void edit() {
        DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance();
        List<Disquera> disqueras = disqueraDao.findAll(); // Recuperando datos desde la BD

        if (disqueras == null || disqueras.isEmpty()) {
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

            // Buscar la disquera en la base de datos
            Disquera disquera = disqueras.stream()
                    .filter(e -> e.getId() != null && e.getId().equals(idBuscado))
                    .findFirst()
                    .orElse(null);

            if (disquera == null) {
                System.out.println("ID incorrecto, intenta nuevamente.");
            } else {
                System.out.println("Ingrese el nuevo nombre de la disquera:");
                String nuevoNombre = ReadUtil.read(); // Captura el nuevo nombre

                if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                    disquera.setNombre(nuevoNombre); // Solo modifica si hay entrada válida
                    boolean actualizado = disqueraDao.update(disquera); // Guarda cambios en BD

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
        DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance();
        List<Disquera> disqueras = disqueraDao.findAll(); // Recuperando datos desde la BD

        if (disqueras == null || disqueras.isEmpty()) {
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

            Disquera disquera = disqueras.stream()
                    .filter(e -> e.getId() != null && e.getId().equals(idBuscado))
                    .findFirst()
                    .orElse(null);

            if (disquera == null) {
                System.out.println("ID incorrecto, intenta nuevamente.");
            } else {
                boolean eliminado = disqueraDao.delete(disquera); // Llama al método que borra en BD

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
        System.out.println("Menú Disquera");
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
