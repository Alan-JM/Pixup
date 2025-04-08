package org.alandoc.pixup.jdbc;

import org.alandoc.pixup.model.Estado;

import java.util.List;

public interface EstadoJdbc
{
    List<Estado> findAll( );
}