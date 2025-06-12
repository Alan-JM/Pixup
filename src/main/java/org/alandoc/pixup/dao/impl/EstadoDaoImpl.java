package org.alandoc.pixup.dao.impl;

import org.alandoc.pixup.dao.EstadoDao;
import org.alandoc.pixup.hibernate.HibernateUtil;
import org.alandoc.pixup.model.Estado;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EstadoDaoImpl implements EstadoDao {
    private static EstadoDaoImpl estadoDaoImpl;

    private EstadoDaoImpl() {}

    public static EstadoDaoImpl getInstance() {
        if (estadoDaoImpl == null) {
            estadoDaoImpl = new EstadoDaoImpl();
        }
        return estadoDaoImpl;
    }

    @Override
    public List<Estado> findAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("FROM Estado", Estado.class).list();
        }
    }

    @Override
    public boolean save(Estado estado) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(estado); //  Guarda en BD
            tx.commit(); //  Confirma cambios
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Estado estado) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(estado);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Estado estado) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(estado);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Estado findById(int id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Estado.class, id);
        }
    }
}