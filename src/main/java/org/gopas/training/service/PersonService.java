package org.gopas.training.service;

import javax.ejb.EJB;
import org.gopas.training.persistence.dao.PersonDao;
import org.gopas.training.persistence.model.Person;

/**
 *
 * @author Seda
 */
public class PersonService {
    
    @EJB
    private PersonDao personDao;
        
    private PersonService(PersonDao personDao){
        this.personDao = personDao;
    }
    
    public Person getPersonById(Long id){
        return personDao.getPersonById(id);
    }
}
