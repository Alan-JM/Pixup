package org.alandoc.pixup.dao.impl;

import org.alandoc.pixup.dao.DiscoDao;
import org.alandoc.pixup.hibernate.HibernateUtil;
import org.alandoc.pixup.model.Disco;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DiscoDaoImpl implements DiscoDao {
    private static DiscoDaoImpl discoDaoImpl;

    private DiscoDaoImpl() {}

    public static DiscoDaoImpl getInstance() {
        if (discoDaoImpl == null) {
            discoDaoImpl = new DiscoDaoImpl();
        }
        return discoDaoImpl;
    }

    @Override
    public List<Disco> findAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("FROM Disco ", Disco.class).list();
        }
    }

    @Override
    public boolean save(Disco disco) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(disco); //  Guarda en BD
            tx.commit(); //  Confirma cambios
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Disco disco) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(disco);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Disco disco) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(disco);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Disco findById(int id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Disco.class, id);
        }
    }



}
