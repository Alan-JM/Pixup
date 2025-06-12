package org.alandoc.pixup.dao.impl;

import org.alandoc.pixup.dao.GeneroMusicalDao;
import org.alandoc.pixup.hibernate.HibernateUtil;
import org.alandoc.pixup.model.Disquera;
import org.alandoc.pixup.model.GeneroMusical;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GeneroMusicalDaoImpl implements GeneroMusicalDao {
    private static GeneroMusicalDaoImpl generoMusicalDaoImpl;

    private GeneroMusicalDaoImpl() {}

    public static GeneroMusicalDaoImpl getInstance() {
        if (generoMusicalDaoImpl == null) {
            generoMusicalDaoImpl = new GeneroMusicalDaoImpl();
        }
        return generoMusicalDaoImpl;
    }

    @Override
    public List<GeneroMusical> findAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("FROM GeneroMusical ", GeneroMusical.class).list();
        }
    }

    @Override
    public boolean save(GeneroMusical generoMusical) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(generoMusical); //  Guarda en BD
            tx.commit(); //  Confirma cambios
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(GeneroMusical generoMusical) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(generoMusical);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(GeneroMusical generoMusical) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(generoMusical);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public GeneroMusical findById(int id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(GeneroMusical.class, id);
        }
    }


}
