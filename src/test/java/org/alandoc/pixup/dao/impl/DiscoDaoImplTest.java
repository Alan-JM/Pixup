package org.alandoc.pixup.dao.impl;

import org.alandoc.pixup.dao.ArtistaDao;
import org.alandoc.pixup.dao.DiscoDao;
import org.alandoc.pixup.dao.DisqueraDao;
import org.alandoc.pixup.dao.GeneroMusicalDao;
import org.alandoc.pixup.model.Artista;
import org.alandoc.pixup.model.Disco;
import org.alandoc.pixup.model.Disquera;
import org.alandoc.pixup.model.GeneroMusical;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiscoDaoImplTest {

    @Test
    void findAll() {
        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        List<Disco> discos = discoDao.findAll();
        assertNotNull(discos, "La lista de discos es nula");
        assertFalse(discos.isEmpty(), "No hay discos en la base de datos");
        discos.forEach(System.out::println);
    }

    @Test
    void save() {
        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        Disco disco = new Disco();
        disco.setTitulo("Disco 1");
        disco.setPrecio(0.5F);
        disco.setExistencia(23);
        disco.setDescuento(0.7F);
        disco.setFechaLanzamiento(java.sql.Date.valueOf("2008-12-19"));
        disco.setImagen("Verde");
        DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance();
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
GeneroMusicalDao generoMusicalDao = GeneroMusicalDaoImpl.getInstance();

        disco.setDisquera(disqueraDao.findById(2));
        disco.setArtista(artistaDao.findById(5));
        disco.setGeneroMusical(generoMusicalDao.findById(2));
        boolean res = discoDao.save(disco);
        assertTrue(res, "La inserción del disco ha fallado");

        Disco discoGuardado = discoDao.findById(disco.getId());
        assertNotNull(discoGuardado, "El disco no fue guardado correctamente");
        assertEquals("Disco 1", discoGuardado.getTitulo()  );
    }

    @Test
    void update() {
        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        Disco disco = discoDao.findById(1);
        assertNotNull(disco, "El disco con ID 1 no existe");

        disco.setTitulo("Disco actualizado");
        disco.setPrecio(0.8F);
        disco.setExistencia(19);
        disco.setDescuento(0.7F);
        disco.setFechaLanzamiento(java.sql.Date.valueOf("2003-02-09"));
            disco.setImagen("Sol amarillo");
        DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance();
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        GeneroMusicalDao generoMusicalDao = GeneroMusicalDaoImpl.getInstance();

        disco.setDisquera(disqueraDao.findById(2));
        disco.setArtista(artistaDao.findById(5));
        disco.setGeneroMusical(generoMusicalDao.findById(2));
        boolean res = discoDao.update(disco);
        assertTrue(res, "La actualización de la disco ha fallado");

        Disco discoActualizado = discoDao.findById(1);
        assertEquals("Disco actualizado", discoActualizado.getTitulo(), "El nombre del disco no se actualizó correctamente");
    }

    @Test
    void delete() {
        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        Disco disco = discoDao.findById(1);
        assertNotNull(disco, "El disco con ID 1 no existe");

        boolean res = discoDao.delete(disco);
        assertTrue(res, "La eliminación del disco ha fallado");

        Disco discoEliminado = discoDao.findById(1);
        assertNull(discoEliminado, "El disco aún existe después de la eliminación");
    }

    @Test
    void findById() {
        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        Disco disco = discoDao.findById(1);

        assertNotNull(disco, "La disco con ID 1 no existe");
        assertEquals(1, disco.getId(), "El ID del disco no coincide");
        assertEquals("Disco 1", disco.getTitulo(), "El nombre del disco no coincide");
    }
}