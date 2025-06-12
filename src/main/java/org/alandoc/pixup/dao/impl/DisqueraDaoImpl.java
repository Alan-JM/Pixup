package org.alandoc.pixup.dao.impl;

import org.alandoc.pixup.dao.DisqueraDao;
import org.alandoc.pixup.hibernate.HibernateUtil;
import org.alandoc.pixup.model.Disquera;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DisqueraDaoImpl implements DisqueraDao {
    private static DisqueraDaoImpl disqueraDaoImpl;

    private DisqueraDaoImpl() {}

    public static DisqueraDaoImpl getInstance() {
        if (disqueraDaoImpl == null) {
            disqueraDaoImpl = new DisqueraDaoImpl();
        }
        return disqueraDaoImpl;
    }

    @Override
    public List<Disquera> findAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("FROM Disquera ", Disquera.class).list();
        }
    }

    @Override
    public boolean save(Disquera disquera) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(disquera); //  Guarda en BD
            tx.commit(); //  Confirma cambios
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Disquera disquera) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(disquera);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Disquera disquera) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(disquera);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Disquera findById(int id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Disquera.class, id);
        }
    }


}
