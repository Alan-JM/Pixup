package org.alandoc.pixup.dao.impl;

import org.alandoc.pixup.dao.DisqueraDao;
import org.alandoc.pixup.model.Disquera;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisqueraDaoImplTest {


    @Test
    void findAll() {
        DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance();
        List<Disquera> disqueras = disqueraDao.findAll();
        assertNotNull(disqueras, "La lista de disqueras es nula");
        assertFalse(disqueras.isEmpty(), "No hay disqueras en la base de datos");
        disqueras.forEach(System.out::println);
    }

    @Test
    void save() {
        DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance();
        Disquera disquera = new Disquera();
        disquera.setNombre("Grupo");

        boolean res = disqueraDao.save(disquera);
        assertTrue(res, "La inserción de la disquera ha fallado");

        Disquera disqueraGuardado = disqueraDao.findById(disquera.getId());
        assertNotNull(disqueraGuardado, "La disquera no fue guardado correctamente");
        assertEquals("Grupo", disqueraGuardado.getNombre());
    }

    @Test
    void update() {
        DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance();
        Disquera disquera = disqueraDao.findById(7);
        assertNotNull(disquera, "La disqura con ID 1 no existe");

        disquera.setNombre("EMI");
        boolean res = disqueraDao.update(disquera);
        assertTrue(res, "La actualización de la disquera ha fallado");

        Disquera disqueraActualizado = disqueraDao.findById(7);
        assertEquals("EMI", disqueraActualizado.getNombre(), "El nombre de la  Disquera no se actualizó correctamente");
    }

    @Test
    void delete() {
        DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance();
        Disquera disquera = disqueraDao.findById(7);
        assertNotNull(disquera, "La disquera con ID 1 no existe");

        boolean res = disqueraDao.delete(disquera);
        assertTrue(res, "La eliminación de la Disquera ha fallado");

        Disquera disqueraEliminado = disqueraDao.findById(7);
        assertNull(disqueraEliminado, "La disquera aún existe después de la eliminación");
    }

    @Test
    void findById() {
        DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance();
        Disquera disquera = disqueraDao.findById(7);

        assertNotNull(disquera, "La disquera con ID 7 no existe");
        assertEquals(7, disquera.getId(), "El ID del disquera no coincide");
        assertEquals("EMI", disquera.getNombre(), "El nombre de la disquera no coincide");
    }

}