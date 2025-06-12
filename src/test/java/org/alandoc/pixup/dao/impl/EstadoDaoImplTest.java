package org.alandoc.pixup.dao.impl;

import org.alandoc.pixup.dao.EstadoDao;
import org.alandoc.pixup.model.Estado;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstadoDaoImplTest {

    @Test
    void findAll() {
        EstadoDao estadoDao = EstadoDaoImpl.getInstance();
        List<Estado> estados = estadoDao.findAll();
        assertNotNull(estados, "La lista de estados es nula");
        assertFalse(estados.isEmpty(), "No hay estados en la base de datos");
        estados.forEach(System.out::println);
    }

    @Test
    void save() {
        EstadoDao estadoDao = EstadoDaoImpl.getInstance();
        Estado estado = new Estado();
        estado.setNombre("CDMX");

        boolean res = estadoDao.save(estado);
        assertTrue(res, "La inserción del estado ha fallado");

        Estado estadoGuardado = estadoDao.findById(estado.getId());
        assertNotNull(estadoGuardado, "El estado no fue guardado correctamente");
        assertEquals("CDMX", estadoGuardado.getNombre());
    }

    @Test
    void update() {
        EstadoDao estadoDao = EstadoDaoImpl.getInstance();
        Estado estado = estadoDao.findById(1);
        assertNotNull(estado, "El estado con ID 1 no existe");

        estado.setNombre("Ciudad de Mexico");
        boolean res = estadoDao.update(estado);
        assertTrue(res, "La actualización del estado ha fallado");

        Estado estadoActualizado = estadoDao.findById(1);
        assertEquals("Ciudad de Mexico", estadoActualizado.getNombre(), "El nombre del estado no se actualizó correctamente");
    }

    @Test
    void delete() {
        EstadoDao estadoDao = EstadoDaoImpl.getInstance();
        Estado estado = estadoDao.findById(1);
        assertNotNull(estado, "El estado con ID 1 no existe");

        boolean res = estadoDao.delete(estado);
        assertTrue(res, "La eliminación del estado ha fallado");

        Estado estadoEliminado = estadoDao.findById(1);
        assertNull(estadoEliminado, "El estado aún existe después de la eliminación");
    }

    @Test
    void findById() {
        EstadoDao estadoDao = EstadoDaoImpl.getInstance();
        Estado estado = estadoDao.findById(1);

        assertNotNull(estado, "El estado con ID 1 no existe");
        assertEquals(1, estado.getId(), "El ID del estado no coincide");
        assertEquals("Ciudad de Mexico", estado.getNombre(), "El nombre del estado no coincide");
    }

}
