package org.alandoc.pixup.dao;

import org.alandoc.pixup.model.Disco;
import org.alandoc.pixup.model.Disquera;

import java.util.List;

public interface DiscoDao {
    List<Disco> findAll( );
    boolean save( Disco disco);
    boolean update(Disco disco);
    boolean delete(Disco disco);
    Disco findById( int id );

}
