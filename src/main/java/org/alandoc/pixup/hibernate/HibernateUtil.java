package org.alandoc.pixup.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public final class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry registry;

	public static boolean loadRegistry() {
		try {
			System.out.println("HibernateUtil.init()");
			registry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml") // Carga la configuración de Hibernate
					.build();
			System.out.println("HibernateUtil.registry");
			return registry != null;
		} catch (Exception e) {
			e.printStackTrace();
			if (registry != null) {
				StandardServiceRegistryBuilder.destroy(registry);
			}
			return false;
		}
	}

	public static boolean loadSessionFactory() {
		try {
			if (registry == null) {
				if (!loadRegistry()) {
					return false;
				}
			}
			System.out.println("HibernateUtil.init.sessionFactory");
			sessionFactory = new MetadataSources(registry)
					.buildMetadata()
					.buildSessionFactory();
			System.out.println("HibernateUtil.sessionFactory");
			return sessionFactory != null;
		} catch (Exception e) {
			e.printStackTrace();
			if (registry != null) {
				StandardServiceRegistryBuilder.destroy(registry);
			}
			return false;
		}
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			if (!loadSessionFactory()) {
				throw new RuntimeException("Error al cargar la SessionFactory");
			}
		}
		return sessionFactory;
	}

	public static Session getSession() {
		return getSessionFactory().openSession();
	}
}