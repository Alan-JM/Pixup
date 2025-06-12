package org.alandoc.pixup.dao.impl;

import org.alandoc.pixup.dao.ArtistaDao;
import org.alandoc.pixup.hibernate.HibernateUtil;
import org.alandoc.pixup.model.Artista;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ArtistaDaoImpl implements ArtistaDao {
    private static ArtistaDaoImpl artistaDaoImpl;

    private ArtistaDaoImpl() {}

    public static ArtistaDaoImpl getInstance() {
        if (artistaDaoImpl == null) {
            artistaDaoImpl = new ArtistaDaoImpl();
        }
        return artistaDaoImpl;
    }

    @Override
    public List<Artista> findAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("FROM Artista", Artista.class).list();
        }
    }

    @Override
    public boolean save(Artista artista) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(artista); //  Guarda en BD
            tx.commit(); //  Confirma cambios
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Artista artista) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(artista);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Artista artista) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(artista);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Artista findById(int id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Artista.class, id);
        }
    }

}
