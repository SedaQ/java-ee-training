package org.gopas.training.persistence.dao;

import javax.ejb.Remote;

/**
 *
 * @author Seda
 */
@Remote
public interface Dao<K, E> {

    void persist(E entity);

    void remove(E entity);

    E findById(K id);

}
