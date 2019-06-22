package org.gopas.training.facade;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.gopas.training.api.PersonDto;
import org.gopas.training.mapping.BeanMapping;
import org.gopas.training.persistence.model.Person;
import org.gopas.training.service.PersonServiceSessionBean;

/**
 *
 * @author Seda
 */
@Stateless
@Transactional
public class PersonFacadeSessionBean {

    @Inject
    private BeanMapping beanMapping;
    @EJB
    private PersonServiceSessionBean personService;

    public PersonFacadeSessionBean() {
    }

    public PersonFacadeSessionBean(PersonServiceSessionBean personService) {
        this.personService = personService;
    }

    public PersonDto getPersonById(Long id) {
        Person person = personService.getPersonById(id);
        return beanMapping.mapTo(person, PersonDto.class);
    }

    public List<PersonDto> getAllPersons() {
        return beanMapping.mapTo(personService.getAllPersons(), PersonDto.class);
    }

    private PersonDto mapPersonToPersonDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setAge(person.getAge());
        personDto.setBirthday(person.getBirthday());
        personDto.setEmail(person.getEmail());
        personDto.setFirstName(person.getFirstName());
        personDto.setIdPerson(person.getIdPerson());
        personDto.setNickname(person.getNickname());
        personDto.setPwd(person.getPwd());
        personDto.setSurname(person.getSurname());

        return personDto;
    }
}
