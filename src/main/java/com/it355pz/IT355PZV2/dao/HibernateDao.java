package com.it355pz.IT355PZV2.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class HibernateDao<E, I> implements Dao<E, I> {
    private final SessionFactory sessionFactory;
    private final Class<E> entityType;
    private final String idFieldName;

    public HibernateDao(SessionFactory sessionFactory, Class<E> entityType) {
        this.sessionFactory = sessionFactory;
        this.entityType = entityType;
        this.idFieldName = sessionFactory.getMetamodel().entity(entityType).getId(Object.class).getName();
    }

    @Override
    @Transactional
    public void insert(E entity) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(entity);
    }

    @Override
    @Transactional
    public void update(E entity) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(entity);
    }

    @Override
    @Transactional
    public void delete(I id) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaDelete<E> delete = builder.createCriteriaDelete(entityType);
        delete.where(builder.equal(delete.from(entityType).get(idFieldName), id));
        session.createQuery(delete).executeUpdate();
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<E> query = builder.createQuery(entityType);
        return session.createQuery(query.select(query.from(entityType))).list();
    }

    @Override
    @Transactional(readOnly = true)
    public E findById(I id) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<E> query = builder.createQuery(entityType);
        query.where(builder.equal(query.from(entityType).get(idFieldName), id));
        return session.createQuery(query).getSingleResult();
    }
    
    @Transactional(readOnly = true)
    public List<E> findBy(I id) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<E> query = builder.createQuery(entityType);
        query.where(builder.equal(query.from(entityType).get(idFieldName), id));
        return session.createQuery(query).getResultList();
    }
}
