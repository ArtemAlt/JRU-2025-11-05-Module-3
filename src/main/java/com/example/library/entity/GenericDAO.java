package com.example.library.entity;

import com.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class GenericDAO <T, IdType> {

    protected final Class<T> entityClass;
    protected final SessionFactory sessionFactory;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public T getById(IdType id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(entityClass, id);
        }
    }

    public List<T> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM " + entityClass.getSimpleName(),
                    entityClass).getResultList();
        }
    }

    public T save(T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
            return entity;
        }
    }

    public T update(T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            T merged = session.merge(entity);
            session.getTransaction().commit();
            return merged;
        }
    }

    public void delete(T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
        }
    }

    public void deleteById(IdType id) {
        T entity = getById(id);
        if (entity != null) {
            delete(entity);
        }
    }
}
