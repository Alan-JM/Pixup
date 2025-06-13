package org.alandoc.pixup.dao;

import org.alandoc.pixup.model.Cancion;
import org.alandoc.pixup.model.Disco;

import java.util.List;

public interface CancionDao {
    List<Cancion> findAll( );
    boolean save(Cancion cancion);
    boolean update(Cancion cancion);
    boolean delete(Cancion cancion);
    Cancion findById( int id );
}
