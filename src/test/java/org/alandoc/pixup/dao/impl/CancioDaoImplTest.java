package org.alandoc.pixup.dao.impl;

import org.alandoc.pixup.dao.ArtistaDao;
import org.alandoc.pixup.dao.CancionDao;
import org.alandoc.pixup.model.Artista;
import org.alandoc.pixup.model.Cancion;
import org.alandoc.pixup.model.Disco;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CancioDaoImplTest {

    @Test
    void findAll() {
        CancionDao cancionDao = CancioDaoImpl.getInstance();
        List<Cancion> cancions = cancionDao.findAll();
        assertNotNull(cancions, "La lista de canciones es nula");
        assertFalse(cancions.isEmpty(), "No hay canciones en la base de datos");
        cancions.forEach(System.out::println);
    }

    @Test
    void save() {
        CancionDao cancionDao = CancioDaoImpl.getInstance();
        Cancion cancion = new Cancion();
        cancion.setTitulo("El cielo a mi favor");
        cancion.setDuracion(java.sql.Time.valueOf("00:05:32"));
        Disco disco = DiscoDaoImpl.getInstance().findById(2);
        if (disco != null) {
            cancion.setDisco(disco);
        } else {
            System.out.println("No se encontró el disco con ID 2.");
        }

        boolean res = cancionDao.save(cancion);
        assertTrue(res, "La inserción del artista ha fallado");

        Cancion cancionGuardado = cancionDao.findById(cancion.getId());
        assertNotNull(cancionGuardado, "La cancion no fue guardado correctamente");
        assertEquals("El cielo a mi favor", cancionGuardado.getTitulo());

    }

    @Test
    void update() {
        CancionDao cancionDao = CancioDaoImpl.getInstance();
        Cancion cancion = cancionDao.findById(1);
        assertNotNull(cancion, "La cancion con ID 1 no existe");

        cancion.setTitulo("Apnea");
        cancion.setDuracion(java.sql.Time.valueOf("00:03:02"));
        Disco disco = DiscoDaoImpl.getInstance().findById(2);
        if (disco != null) {
            cancion.setDisco(disco);
        } else {
            System.out.println("No se encontró el disco con ID 2.");
        }

        boolean res = cancionDao.update(cancion);
        assertTrue(res, "La actualización de la cancion ha fallado");

        Cancion cancionActualizado = cancionDao.findById(1);
        assertEquals("Apnea", cancionActualizado.getTitulo(), "La cancion no se actualizó correctamente");
    }

    @Test
    void delete() {
        CancionDao cancionDao = CancioDaoImpl.getInstance();
        Cancion cancion = cancionDao.findById(1);
        assertNotNull(cancion, "El Artista con ID 1 no existe");

        boolean res = cancionDao.delete(cancion);
        assertTrue(res, "La eliminación de la cancion ha fallado");

        Cancion cancionEliminado = cancionDao.findById(1);
        assertNull(cancionEliminado, "La cancion aún existe después de la eliminación");
    }

    @Test
    void findById() {
        CancionDao cancionDao = CancioDaoImpl.getInstance();
        Cancion cancion = cancionDao.findById(1);

        assertNotNull(cancion, "La cancion con ID 1 no existe");
        assertEquals(1, cancion.getId(), "El ID del cancion no coincide");
        assertEquals("Apnea", cancion.getTitulo(), "El nombre de la cancion no coincide");
    }

}