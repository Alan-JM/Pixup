
package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.dao.CancionDao;
import org.alandoc.pixup.dao.DisqueraDao;
import org.alandoc.pixup.dao.impl.CancioDaoImpl;
import org.alandoc.pixup.dao.impl.DiscoDaoImpl;
import org.alandoc.pixup.dao.impl.DisqueraDaoImpl;
import org.alandoc.pixup.gui.LecturaAccion;
import org.alandoc.pixup.model.Cancion;
import org.alandoc.pixup.model.Catalogo;
import org.alandoc.pixup.model.Disco;
import org.alandoc.pixup.model.Disquera;
import org.alandoc.pixup.util.ReadUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class CatalogosCancion<T extends Catalogo> extends LecturaAccion {

    protected List<T> list;
    protected T t;
    protected boolean flag2;

    public CatalogosCancion() {
        list = new ArrayList<>();
    }

    public boolean isListEmpty() {
        return list.isEmpty();
    }


    public abstract Cancion newT();

    public abstract boolean processNewT(Cancion cancion);

    public abstract void processEditT(Cancion cancion);


    public void print() {
        CancionDao cancionDao = CancioDaoImpl.getInstance(); //  Conexión con BD
        List<Cancion> cancions = cancionDao.findAll(); //  Recuperando datos desde MySQL

        if (cancions == null || cancions.isEmpty()) {
            System.out.println(" No hay canciones guardadas en la base de datos.");
        } else {
            System.out.println("Lista de canciones guardados:");
            cancions.forEach(cancion -> System.out.println("- " + cancion.getId() + "Titulo: " + cancion.getTitulo() + " Duracion: "+ cancion.getDuracion() + " : "+ cancion.getDisco()));
        }
    }



    public void add() {
        CancionDao cancionDao = CancioDaoImpl.getInstance();
        Cancion cancion = new Cancion();
        System.out.println("Ingrese el nombre de la nueva canción:");
        cancion.setTitulo(ReadUtil.read());
        System.out.println("Ingrese la duración (HH:mm:ss):");
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


        System.out.println(" Cancion a insertar: " + cancion.getTitulo()); //  Depuración

        boolean res = cancionDao.save(cancion); //  Guarda en BD
        if (res) {
            System.out.println(" Cancion guardado correctamente.");
        } else {
            System.out.println(" Error al guardar la disquera.");
        }
    }
    public void edit() {
        CancionDao cancionDao = CancioDaoImpl.getInstance();
        List<Cancion> cancions = cancionDao.findAll(); // Recuperando datos desde la BD

        if (cancions == null || cancions.isEmpty()) {
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
            Cancion cancion = cancions.stream()
                    .filter(e -> e.getId() != null && e.getId().equals(idBuscado))
                    .findFirst()
                    .orElse(null);

            if (cancion == null) {
                System.out.println("ID incorrecto, intenta nuevamente.");
            } else {


                System.out.println("Ingrese el nuevo nombre de la disquera:");
                String nuevoTitulo = ReadUtil.read(); // Captura el nuevo nombre
                System.out.println("Ingrese la nueva duración (HH:mm:ss):");
                cancion.setDuracion(ReadUtil.readSqlTime());

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

                if (nuevoTitulo != null && !nuevoTitulo.trim().isEmpty()) {
                    cancion.setTitulo(nuevoTitulo); // Solo modifica si hay entrada válida
                    boolean actualizado = cancionDao.update(cancion); // Guarda cambios en BD

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
    private void processEditT(T cancion) {

    }


    public void remove() {
        CancionDao cancionDao = CancioDaoImpl.getInstance();
        List<Cancion> cancions = cancionDao.findAll(); // Recuperando datos desde la BD

        if (cancions == null || cancions.isEmpty()) {
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

            Cancion cancion = cancions.stream()
                    .filter(e -> e.getId() != null && e.getId().equals(idBuscado))
                    .findFirst()
                    .orElse(null);

            if (cancion == null) {
                System.out.println("ID incorrecto, intenta nuevamente.");
            } else {
                boolean eliminado = cancionDao.delete(cancion); // Llama al metodo que borra en BD

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
        System.out.println("Menú Cancion");
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
