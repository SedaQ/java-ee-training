package org.gopas.training.mapping.otheroptions;

import org.gopas.training.api.PersonDto;
import org.gopas.training.persistence.model.Person;

/**
 *
 * @author SedaQ
 */
public class PersonToPersonDtoConverter implements SuperConverter<Person, PersonDto> {

    @Override
    public PersonDto apply(final Person person) {
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
