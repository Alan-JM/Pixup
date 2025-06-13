package org.alandoc.pixup.gui.consola;

<<<<<<< HEAD
import org.alandoc.pixup.dao.EstadoDao;
import org.alandoc.pixup.dao.impl.EstadoDaoImpl;
import org.alandoc.pixup.gui.LecturaAccion;
import org.alandoc.pixup.model.Catalogo;
import org.alandoc.pixup.model.Estado;
=======
import org.alandoc.pixup.gui.LecturaAccion;
import org.alandoc.pixup.model.Catalogo;
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
import org.alandoc.pixup.util.ReadUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class Catalogos<T extends Catalogo> extends LecturaAccion {
    protected List<T> list;
    protected T t;
    protected boolean flag2;

    public Catalogos() {
        list = new ArrayList<>();
    }

    public boolean isListEmpty() {
        return list.isEmpty();
    }

    public void print() {
<<<<<<< HEAD
        EstadoDao estadoDao = EstadoDaoImpl.getInstance(); //  Conexión con BD
        List<Estado> estados = estadoDao.findAll(); //  Recuperando datos desde MySQL

        if (estados == null || estados.isEmpty()) {
            System.out.println(" No hay estados guardados en la base de datos.");
        } else {
            System.out.println("Lista de estados guardados:");
            estados.forEach(estado -> System.out.println("- " + estado.getId() + ": " + estado.getNombre()));
        }
=======
        if (isListEmpty()) {
            System.out.println("No hay elementos");
            return;
        }
        list.stream().forEach(System.out::println);
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
    }

    public abstract T newT();
    public abstract boolean processNewT(T t);
    public abstract void processEditT(T t);

    public void add() {
<<<<<<< HEAD
        EstadoDao estadoDao = EstadoDaoImpl.getInstance();
        Estado estado = new Estado();
        System.out.println("Ingrese el nombre del nuevo estado:");
        estado.setNombre(ReadUtil.read()); //  Captura entrada del usuario

        System.out.println(" Estado a insertar: " + estado.getNombre()); //  Depuración

        boolean res = estadoDao.save(estado); //  Guarda en BD
        if (res) {
            System.out.println(" Estado guardado correctamente.");
        } else {
            System.out.println(" Error al guardar el estado.");
        }
    }
    public void edit() {
        if (isListEmpty()) {
            System.out.println("No hay elementos para editar.");
=======
        t = newT();
        if (processNewT(t)) {
            t.setId(list.size() + 1);
            list.add(t);
        }
    }

    public void edit() {
        if (isListEmpty()) {
            System.out.println("No hay elementos");
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
            return;
        }
        flag2 = true;
        while (flag2) {
<<<<<<< HEAD
            System.out.println("Ingrese el ID del elemento a editar:");
            print();
            t = list.stream().filter(e -> e.getId().equals(ReadUtil.readInt())).findFirst().orElse(null);
            if (t == null) {
                System.out.println("ID incorrecto, intenta nuevamente.");
            } else {
                processEditT(t);
                flag2 = false;
                System.out.println("Elemento modificado.");
=======
            System.out.println("Ingrese el id del elemento a editar");
            print();
            t = list.stream().filter(e -> e.getId() == ReadUtil.readInt()).findFirst().orElse(null); // <- Corrección aquí
            if (t == null) {
                System.out.println("Id incorrecto, inténtelo nuevamente");
            } else {
                processEditT(t);
                flag2 = false;
                System.out.println("Elemento modificado");
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
            }
        }
    }

    public void remove() {
        if (isListEmpty()) {
<<<<<<< HEAD
            System.out.println(" No hay elementos para borrar.");
=======
            System.out.println("No hay elementos");
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
            return;
        }
        flag2 = true;
        while (flag2) {
<<<<<<< HEAD
            System.out.println("Ingrese el ID del elemento a borrar:");
            print();
            t = list.stream().filter(e -> e.getId().equals(ReadUtil.readInt())).findFirst().orElse(null);
            if (t == null) {
                System.out.println(" ID incorrecto, intenta nuevamente.");
            } else {
                list.remove(t);
                flag2 = false;
                System.out.println(" Elemento borrado.");
=======
            System.out.println("Ingrese el id del elemento a borrar");
            print();
            t = list.stream().filter(e -> e.getId() == ReadUtil.readInt()).findFirst().orElse(null); // <- Corrección aquí
            if (t == null) {
                System.out.println("Id incorrecto, inténtelo nuevamente");
            } else {
                list.remove(t);
                flag2 = false;
                System.out.println("Elemento borrado");
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
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
<<<<<<< HEAD
=======
            case 5:
                System.out.println("Saliendo del menú...");
                break;
            default:
                System.out.println("Opción inválida. Inténtelo nuevamente.");
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
        }
    }

    @Override
    public void despliegaMenu() {
<<<<<<< HEAD
        System.out.println("Menú Estado");
=======
        System.out.println("Menú de Estado:");
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
        System.out.println("Seleccione una opción:");
        System.out.println("1.- Agregar");
        System.out.println("2.- Editar");
        System.out.println("3.- Borrar");
<<<<<<< HEAD
        System.out.println("4.- Imprimir estados guardados en BD");
=======
        System.out.println("4.- Imprimir");
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
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
<<<<<<< HEAD


=======
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
}