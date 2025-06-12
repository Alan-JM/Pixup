package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.model.GeneroMusical;
import org.alandoc.pixup.util.ReadUtil;

public class GeneroMusicalCatalogo extends CatalogosGeneroMusical<GeneroMusical>{

    public static GeneroMusicalCatalogo generoMusicalCatalogo;
    private GeneroMusicalCatalogo( )
    {
        super();
    }

    public static GeneroMusicalCatalogo getInstance( )
    {
        if(generoMusicalCatalogo==null)
        {
            generoMusicalCatalogo = new GeneroMusicalCatalogo();
        }
        return generoMusicalCatalogo;
    }

    @Override
    public GeneroMusical newT() {
        return new GeneroMusical();
    }

    @Override
    public boolean processNewT(GeneroMusical generoMusical) {
        System.out.println("Teclee un genero musical" );
        generoMusical.setNombre( ReadUtil.read( ) );
        return true;
    }

    @Override
    public void processEditT(GeneroMusical generoMusical) {
        System.out.println("Id del genero musical " + generoMusical.getId( ) );
        System.out.println("Genero musical a editar: " + generoMusical.getNombre( ) );
        System.out.println("Teclee el valor nuevo del genero musical" );
        generoMusical.setNombre( ReadUtil.read( ) );
    }


}
