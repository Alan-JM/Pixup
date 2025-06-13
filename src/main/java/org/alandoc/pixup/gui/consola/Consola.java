package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.gui.LecturaAccion;
import org.alandoc.pixup.negocio.Ejecutable;

<<<<<<< HEAD
public class Consola extends LecturaAccion
{
    private static Consola consola;

    private Consola()
    {
    }

    public static Consola getInstance( )
    {
        if(consola==null)
        {
=======
public class Consola extends LecturaAccion {
    private static Consola consola;

    private Consola() {
    }

    public static Consola getInstance() {
        if (consola == null) {
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
            consola = new Consola();
        }
        return consola;
    }

    @Override
<<<<<<< HEAD
    public void despliegaMenu()
    {
=======
    public void despliegaMenu() {
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
        System.out.println("Seleccione una opcion:");
        System.out.println("1.-Catálogos");
        System.out.println("2.-Salir");
    }

    @Override
<<<<<<< HEAD
    public int valorMinMenu()
    {
=======
    public int valorMinMenu() {
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
        return 1;
    }

    @Override
<<<<<<< HEAD
    public int valorMaxMenu()
    {
=======
    public int valorMaxMenu() {
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
        return 2;
    }

    @Override
<<<<<<< HEAD
    public void procesaOpcion()
    {
        Ejecutable ejecutable = null;
        System.out.println("Opcion: " + opcion);
        if(opcion==1)
        {
            ejecutable = ListaCatalogos.getInstance( );
        }
        ejecutable.setFlag( true );
        ejecutable.run( );
    }

=======
    public void procesaOpcion() {
        Ejecutable ejecutable = null;
        System.out.println("Opcion: " + opcion);
        if (opcion == 1) {
            ejecutable = ListaCatalogos.getInstance();
        }
        ejecutable.setFlag(true);
        ejecutable.run();
    }
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
}
