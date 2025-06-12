package org.alandoc.pixup.dao.impl;

import org.alandoc.pixup.dao.DisqueraDao;
import org.alandoc.pixup.dao.GeneroMusicalDao;
import org.alandoc.pixup.model.Disquera;
import org.alandoc.pixup.model.GeneroMusical;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneroMusicalDaoImplTest {

    @Test
    void findAll() {
        GeneroMusicalDao generoMusicalDao = GeneroMusicalDaoImpl.getInstance();
        List<GeneroMusical> generoMusicals = generoMusicalDao.findAll();
        assertNotNull(generoMusicals, "La lista de generos musicales es nula");
        assertFalse(generoMusicals.isEmpty(), "No hay generos musicales en la base de datos");
        generoMusicals.forEach(System.out::println);
    }

    @Test
    void save() {
        GeneroMusicalDao generoMusicalDao = GeneroMusicalDaoImpl.getInstance();
        GeneroMusical generoMusical = new GeneroMusical();
        generoMusical.setNombre("Pop");

        boolean res = generoMusicalDao.save(generoMusical);
        assertTrue(res, "La inserción del genero musical ha fallado");

        GeneroMusical generoMusicalGuardado = generoMusicalDao.findById(generoMusical.getId());
        assertNotNull(generoMusicalGuardado, "El genero musical no fue guardado correctamente");
        assertEquals("Pop", generoMusicalGuardado.getNombre());
    }

    @Test
    void update() {
        GeneroMusicalDao generoMusicalDao = GeneroMusicalDaoImpl.getInstance();
        GeneroMusical generoMusical = generoMusicalDao.findById(1);
        assertNotNull(generoMusical, "El genero musical con ID 1 no existe");

        generoMusical.setNombre("rock");
        boolean res = generoMusicalDao.update(generoMusical);
        assertTrue(res, "La actualización del genero musical ha fallado");

        GeneroMusical generoMusicalActualizado = generoMusicalDao.findById(1);
        assertEquals("rock", generoMusicalActualizado.getNombre(), "El nombre del genero musical no se actualizó correctamente");
    }

    @Test
    void delete() {
        GeneroMusicalDao generoMusicalDao = GeneroMusicalDaoImpl.getInstance();
        GeneroMusical generoMusical = generoMusicalDao.findById(1);
        assertNotNull(generoMusical, "El genero musical con ID 1 no existe");

        boolean res = generoMusicalDao.delete(generoMusical);
        assertTrue(res, "La eliminación del genero musical ha fallado");

        GeneroMusical generoMusicalEliminado = generoMusicalDao.findById(1);
        assertNull(generoMusicalEliminado, "El genero musical aún existe después de la eliminación");
    }

    @Test
    void findById() {
        GeneroMusicalDao generoMusicalDao = GeneroMusicalDaoImpl.getInstance();
        GeneroMusical generoMusical = generoMusicalDao.findById(1);

        assertNotNull(generoMusical, "La genero musical con ID 1 no existe");
        assertEquals(1, generoMusical.getId(), "El ID del genero musical no coincide");
        assertEquals("rock", generoMusical.getNombre(), "El nombre del genero musical no coincide");
    }

}