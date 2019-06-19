package org.gopas.training.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import org.gopas.training.api.PersonDto;
import org.gopas.training.persistence.model.Person;
import org.gopas.training.service.PersonService;

/**
 *
 * @author Seda
 */
@Transactional
@Stateless
public class PersonFacade {

    @Inject
    private PersonService personService;

    public PersonFacade() {
    }

    public PersonFacade(PersonService personService) {
        this.personService = personService;
    }

    public PersonDto getPersonById(Long id) {
        Person person = personService.getPersonById(id);
        return mapPersonToPersonDto(person);
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
