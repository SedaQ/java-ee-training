package org.gopas.training.persistence.dao;

import java.util.List;
import javax.ejb.Remote;
import org.gopas.training.persistence.model.Person;
import org.gopas.training.persistence.pojos.PersonIdEmailSurnameCityProjection;
import org.gopas.training.persistence.pojos.PersonWithContactsProjection;

/**
 * @author Pavel Seda
 */
@Remote
public interface PersonDao extends Dao<Long, Person> {

    Person getPersonByIdNamedQuery(Long id);

    List<Person> findAllPersons();

    List<Person> findAllPersonsNamedQuery();

    List<Person> findAllNativeQuery();

    List<Person> findAllPersonsWithAddresses();

    List<Person> findAllPersonsInfoWithEntityGraph();

    List<Person> findAllPersonsWithAddressSelectively();

    List<PersonIdEmailSurnameCityProjection> findAllPersonsEmailSurnameCityProjection();

    List<PersonWithContactsProjection> findAllPersonsWithContacts();
}
