package org.gopas.training.persistence.dao;

import java.lang.reflect.ParameterizedType;
import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Seda
 *
 * @param <K>
 * @param <E>
 */
@Remote
public abstract class AbstractJpaDao<K, E> implements Dao<K, E> {

    protected Class<E> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public AbstractJpaDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
    }

    @Override
    public void persist(E entity) {
        entityManager.persist(entity);
    }

    @Override
    public void remove(E entity) {
        entityManager.remove(entity);
    }

    @Override
    public E findById(K id) {
        return entityManager.find(entityClass, id);
    }
}
