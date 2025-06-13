package org.alandoc.pixup.dao.impl;

import org.alandoc.pixup.dao.CancionDao;
import org.alandoc.pixup.hibernate.HibernateUtil;
import org.alandoc.pixup.model.Artista;
import org.alandoc.pixup.model.Cancion;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CancioDaoImpl implements CancionDao {
    private static CancioDaoImpl cancioDaoImpl;

    private CancioDaoImpl() {}

    public static CancioDaoImpl getInstance() {
        if (cancioDaoImpl == null) {
            cancioDaoImpl = new CancioDaoImpl();
        }
        return cancioDaoImpl;
    }

    @Override
    public List<Cancion> findAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("FROM Cancion", Cancion.class).list();
        }
    }

    @Override
    public boolean save(Cancion cancion) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(cancion); //  Guarda en BD
            tx.commit(); //  Confirma cambios
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Cancion cancion) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(cancion);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Cancion cancion) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(cancion);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Cancion findById(int id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Cancion.class, id);
        }
    }


}
