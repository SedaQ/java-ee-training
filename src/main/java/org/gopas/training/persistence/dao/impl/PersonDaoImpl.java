package org.gopas.training.persistence.dao.impl;

import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import java.util.List;
import javax.ejb.Stateless;
import org.gopas.training.persistence.dao.AbstractJpaDao;
import org.gopas.training.persistence.dao.PersonDao;
import org.gopas.training.persistence.model.Person;
import org.gopas.training.persistence.pojos.PersonIdEmailSurnameCityProjection;
import org.gopas.training.persistence.pojos.PersonWithContactsProjection;

/**
 * @author Pavel Seda
 */
@Stateless
public class PersonDaoImpl extends AbstractJpaDao<Long, Person> implements PersonDao {

    public PersonDaoImpl(){}
    
    @Override
    public Person getPersonByIdNamedQuery(Long id) {
        TypedQuery<Person> persons = entityManager.createNamedQuery("Person.findById", Person.class).setParameter("id", id);
        return persons.getSingleResult();
    }

    @Override
    public List<Person> findAllPersons() {
        TypedQuery<Person> persons = entityManager.createQuery("SELECT p FROM Person p", Person.class);
        return persons.getResultList();
    }

    @Override
    public List<Person> findAllPersonsNamedQuery() {
        return entityManager.createNamedQuery("Person.findAll", Person.class).getResultList();
    }

    @Override
    public List<Person> findAllNativeQuery() {
        return entityManager.createNamedQuery("Person.findAllNativeQuery", Person.class).getResultList();
    }

    @Override
    public List<Person> findAllPersonsWithAddresses() {
        TypedQuery<Person> persons = entityManager.createQuery("SELECT p FROM Person p JOIN FETCH p.address", Person.class);
        return persons.getResultList();
    }

    @Override
    public List<Person> findAllPersonsInfoWithEntityGraph() {
        EntityGraph entityGraph = entityManager.getEntityGraph("person-with-address");
        List<Person> persons = entityManager.createQuery("SELECT p FROM Person p", Person.class)
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getResultList();
        return persons;
    }

    @Override
    public List<PersonIdEmailSurnameCityProjection> findAllPersonsEmailSurnameCityProjection() {
        List<PersonIdEmailSurnameCityProjection> persons =
                entityManager.createQuery("SELECT new com.sedaq.training.jpa.pojos.PersonIdEmailSurnameCityProjection(p.id, p.email, p.surname, p.address.city) FROM Person p " +
                        "JOIN p.address")
                        .getResultList();
        return persons;
    }

    @Override
    public List<Person> findAllPersonsWithAddressSelectively() {
        TypedQuery<Person> persons = entityManager.createQuery("SELECT new com.sedaq.training.jpa.model.Person(p.id, p.email, p.nickname) FROM Person p", Person.class);
        return persons.getResultList();
    }

    /**
     * This project does not work.. the Set is not passed to the given constructor
     *
     * @return
     */
    @Override
    public List<PersonWithContactsProjection> findAllPersonsWithContacts() {
        return entityManager.createQuery("SELECT new com.sedaq.training.jpa.pojos.PersonWithContactsProjection(p.id, p.email, p.surname, p.address.city, p.contacts) " +
                "FROM Person p " +
                "JOIN p.contacts")
                .getResultList();
    }
}
