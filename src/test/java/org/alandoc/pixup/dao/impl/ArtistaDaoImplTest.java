package org.alandoc.pixup.dao.impl;

import org.alandoc.pixup.dao.ArtistaDao;
import org.alandoc.pixup.model.Artista;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArtistaDaoImplTest {

    @Test
    void findAll() {
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        List<Artista> artistas = artistaDao.findAll();
        assertNotNull(artistas, "La lista de artistas es nula");
        assertFalse(artistas.isEmpty(), "No hay artistas en la base de datos");
        artistas.forEach(System.out::println);
    }

    @Test
    void save() {
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        Artista artista = new Artista();
        artista.setNombre("Silvio");

        boolean res = artistaDao.save(artista);
        assertTrue(res, "La inserción del artista ha fallado");

        Artista artistaGuardado = artistaDao.findById(artista.getId());
        assertNotNull(artistaGuardado, "El Artista no fue guardado correctamente");
        assertEquals("Silvio", artistaGuardado.getNombre());
    }

    @Test
    void update() {
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        Artista artista = artistaDao.findById(1);
        assertNotNull(artista, "El Artista con ID 1 no existe");

        artista.setNombre("Bruno Mars");
        boolean res = artistaDao.update(artista);
        assertTrue(res, "La actualización del Artista ha fallado");

        Artista artistaActualizado = artistaDao.findById(1);
        assertEquals("Bruno Mars", artistaActualizado.getNombre(), "El nombre del Artista no se actualizó correctamente");
    }

    @Test
    void delete() {
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        Artista artista = artistaDao.findById(1);
        assertNotNull(artista, "El Artista con ID 1 no existe");

        boolean res = artistaDao.delete(artista);
        assertTrue(res, "La eliminación del Artista ha fallado");

        Artista artistaEliminado = artistaDao.findById(1);
        assertNull(artistaEliminado, "El Artista aún existe después de la eliminación");
    }

    @Test
    void findById() {
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        Artista artista = artistaDao.findById(2);

        assertNotNull(artista, "El Artista con ID 1 no existe");
        assertEquals(2, artista.getId(), "El ID del Artista no coincide");
        assertEquals("Michaek Jackson", artista.getNombre(), "El nombre del artista no coincide");
    }

}