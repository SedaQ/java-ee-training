package org.gopas.training.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import org.gopas.training.persistence.dao.PersonDao;
import org.gopas.training.persistence.model.Person;

/**
 *
 * @author Seda
 */
@Stateless
public class PersonService {
       
    @Inject
    private PersonDao personDao;

    public PersonService() {
    }
    
    private PersonService(PersonDao personDao){
        this.personDao = personDao;
    }
    
    public Person getPersonById(Long id){
        return personDao.findById(id);
    }
}
