
package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.gui.LecturaAccion;
import org.alandoc.pixup.negocio.Ejecutable;

public class ListaCatalogos extends LecturaAccion
{
    public static ListaCatalogos listaCatalogos;
    private ListaCatalogos()
    {
    }
    public static ListaCatalogos getInstance( )
    {
        if(listaCatalogos==null)
        {
            listaCatalogos = new ListaCatalogos();
        }
        return listaCatalogos;
    }

    @Override
    public void despliegaMenu()
    {
        System.out.println( "Seleccione una opcion:" );
        System.out.println( "1.-Estado");
        System.out.println( "2.-Municipio");
        System.out.println( "3.-Colonia");
        System.out.println("4.-Artista");
        System.out.println( "5.-Disquera");
        System.out.println( "6.-Genero Musical");
        System.out.println( "7.-Disco");
        System.out.println( "8.-Cancion");
        System.out.println( "9.-Salir");
    }
    @Override
    public int valorMinMenu()
    {
        return 1;
    }

    @Override
    public int valorMaxMenu()
    {
        return 9;
    }

    @Override
    public void procesaOpcion()
    {
        Ejecutable ejecutable = null;

        switch (opcion)
        {
            case 1:
                ejecutable = EstadoCatalogo.getInstance( );
                break;
            case 2:
                System.out.println( "No implementado" );
                break;
            case 3:
                System.out.println( "No implementado" );
                break;
            case 4:
                ejecutable = ArtistaCatalogo.getInstance( );
                break;
            case 5:
                ejecutable = DisqueraCatalogo.getInstance( );
                break;
            case 6:
                ejecutable = GeneroMusicalCatalogo.getInstance( );
                break;
            case 7:
                ejecutable = DiscoCatalogo.getInstance( );
                break;
            case 8:
                ejecutable = CancionCatalogo.getInstance( );
                break;
        }
        ejecutable.setFlag( true );
        ejecutable.run( );

    }
}
