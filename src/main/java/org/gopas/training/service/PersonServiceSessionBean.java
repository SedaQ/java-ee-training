package org.gopas.training.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.gopas.training.persistence.dao.PersonDao;
import org.gopas.training.persistence.model.Person;
import org.gopas.training.utils.interceptors.bindings.Auditable;

/**
 *
 * @author Seda
 */
@Stateless
public class PersonServiceSessionBean {

    @EJB
    private PersonDao personDao;

    public PersonServiceSessionBean() {
    }

    private PersonServiceSessionBean(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Auditable
    public Person getPersonById(Long id) {
        return personDao.findById(id);
    }

    public List<Person> getAllPersons() {
        return personDao.findAllPersons();
    }

    public List<Person> getPersonsWithBirthday() {
        return personDao.getPersonsWithBirthday();
    }

}
