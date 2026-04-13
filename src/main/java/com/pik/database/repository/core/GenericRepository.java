package com.pik.database.repository.core;

import java.util.List;
import java.util.function.Consumer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class GenericRepository<T> {

    protected final SessionFactory factory;
    private final Class<T> entityClass;

    protected GenericRepository(SessionFactory factory, Class<T> entityClass) {
        this.factory = factory;
        this.entityClass = entityClass;
    }

    protected void executeInTransaction(Consumer<Session> action) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            action.accept(session);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            throw e;
        }
    }

    public void save(T entity) {
        executeInTransaction(session -> session.persist(entity));
    }

    public T findById(long id) {
        try (Session session = factory.openSession()) {
            return session.get(entityClass, id);
        }
    }

    public List<T> getAll() {
        try (Session session = factory.openSession()) {
            CriteriaBuilder critBuilder = session.getCriteriaBuilder();
            CriteriaQuery<T> critQuery = critBuilder.createQuery(entityClass);

            Root<T> rootEntry = critQuery.from(entityClass);
            CriteriaQuery<T> all = critQuery.select(rootEntry);

            return session.createQuery(all).list();
        }
    }
}
