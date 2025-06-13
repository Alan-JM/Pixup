
package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.dao.EstadoDao;
import org.alandoc.pixup.dao.impl.EstadoDaoImpl;
import org.alandoc.pixup.gui.LecturaAccion;
import org.alandoc.pixup.model.Catalogo;
import org.alandoc.pixup.model.Estado;
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
        EstadoDao estadoDao = EstadoDaoImpl.getInstance(); //  Conexión con BD
        List<Estado> estados = estadoDao.findAll(); //  Recuperando datos desde MySQL

        if (estados == null || estados.isEmpty()) {
            System.out.println(" No hay estados guardados en la base de datos.");
        } else {
            System.out.println("Lista de estados guardados:");
            estados.forEach(estado -> System.out.println("- " + estado.getId() + ": " + estado.getNombre()));
        }
    }

    public abstract T newT();
    public abstract boolean processNewT(T t);
    public abstract void processEditT(T t);

    public void add() {
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
            return;
        }
        flag2 = true;
        while (flag2) {
            System.out.println("Ingrese el ID del elemento a editar:");
            print();
            t = list.stream().filter(e -> e.getId().equals(ReadUtil.readInt())).findFirst().orElse(null);
            if (t == null) {
                System.out.println("ID incorrecto, intenta nuevamente.");
            } else {
                processEditT(t);
                flag2 = false;
                System.out.println("Elemento modificado.");
            }
        }
    }

    public void remove() {
        if (isListEmpty()) {
            System.out.println(" No hay elementos para borrar.");
            return;
        }
        flag2 = true;
        while (flag2) {
            System.out.println("Ingrese el ID del elemento a borrar:");
            print();
            t = list.stream().filter(e -> e.getId().equals(ReadUtil.readInt())).findFirst().orElse(null);
            if (t == null) {
                System.out.println(" ID incorrecto, intenta nuevamente.");
            } else {
                list.remove(t);
                flag2 = false;
                System.out.println(" Elemento borrado.");
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
        System.out.println("Menú Estado");
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
