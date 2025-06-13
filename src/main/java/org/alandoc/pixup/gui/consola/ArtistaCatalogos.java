package org.alandoc.pixup.gui.consola;

import org.alandoc.pixup.model.Artista;
import org.alandoc.pixup.util.ReadUtil;

import java.io.File;

public class ArtistaCatalogos extends Catalogos<Artista>{
    private static ArtistaCatalogos artistaCatalogos;

    private ArtistaCatalogos() {
    }
    public static ArtistaCatalogos getInstance(){

        if(artistaCatalogos == null){
            artistaCatalogos = new ArtistaCatalogos();

        }
        return artistaCatalogos;
    }




    @Override
    public Artista newT() {
        return new Artista();
    }

    @Override
    public boolean processNewT(Artista artista) {
        System.out.println("Escribe el nombre del artista");
        artista.setArtista(ReadUtil.read());
        return true;
    }

    @Override
    public void processEditT(Artista artista) {
        System.out.println("El nombre del artista es: " + artista.getArtista());
        System.out.println("Escribe el nuevo valor del artista:");
        artista.setArtista(ReadUtil.read());
    }

}
