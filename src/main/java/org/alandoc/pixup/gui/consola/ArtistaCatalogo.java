package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.model.Artista;
import org.alandoc.pixup.util.ReadUtil;

public class ArtistaCatalogo extends CatalogosArtista<Artista>{

    public static ArtistaCatalogo artistaCatalogo;
    private ArtistaCatalogo( )
    {
        super();
    }

    public static ArtistaCatalogo getInstance( )
    {
        if(artistaCatalogo==null)
        {
            artistaCatalogo = new ArtistaCatalogo();
        }
        return artistaCatalogo;
    }

    @Override
    public Artista newT() {
        return new Artista();
    }

    @Override
    public boolean processNewT(Artista artista) {
        System.out.println("Teclee un Artista" );
        artista.setNombre( ReadUtil.read( ) );
        return true;
    }

    @Override
    public void processEditT(Artista artista) {
        System.out.println("Id del artista " + artista.getId( ) );
        System.out.println("Artista a editar: " + artista.getNombre( ) );
        System.out.println("Teclee el valor nuevo del artista" );
        artista.setNombre( ReadUtil.read( ) );
    }


}