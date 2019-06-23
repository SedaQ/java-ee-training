package org.gopas.training.facade;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.gopas.training.api.MeetingsInPastDto;
import org.gopas.training.api.PersonDto;
import org.gopas.training.mapping.BeanMapping;
import org.gopas.training.persistence.model.Meeting;
import org.gopas.training.persistence.model.Person;
import org.gopas.training.service.MeetingServiceSessionBean;
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
    @EJB
    private MeetingServiceSessionBean meetingService;

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

    public List<MeetingsInPastDto> getMeetingsInPast() throws InterruptedException, ExecutionException {
        Future<List<Meeting>> meetingsFuture = meetingService.meetingsInPast();
        List<Meeting> meetings = meetingsFuture.get();
        return beanMapping.mapTo(meetings, MeetingsInPastDto.class);
    }

    private PersonDto mapPersonToPersonDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setAge(person.getAge());
        personDto.setBirthday(person.getBirthday());
        personDto.setEmail(person.getEmail());
        personDto.setFirstName(person.getFirstName());
        personDto.setIdPerson(person.getIdPerson());
        personDto.setNickname(person.getNickname());
        personDto.setSurname(person.getSurname());

        return personDto;
    }
}
