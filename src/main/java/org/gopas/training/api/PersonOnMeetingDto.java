package org.gopas.training.api;

import java.time.LocalDate;

/**
 *
 * @author SedaQ
 */
public class PersonOnMeetingDto {

    private Long idPerson;
    private String email;
    private String nickname;
    private String firstName;
    private String surname;
    private LocalDate birthday;
    private Integer age;

    public PersonOnMeetingDto() {
    }

    public PersonOnMeetingDto(Long idPerson, String email, String nickname, String firstName, String surname, LocalDate birthday, Integer age) {
        this.idPerson = idPerson;
        this.email = email;
        this.nickname = nickname;
        this.firstName = firstName;
        this.surname = surname;
        this.birthday = birthday;
        this.age = age;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonOnMeetingDto{" + "idPerson=" + idPerson + ", email=" + email + ", nickname=" + nickname + ", firstName=" + firstName + ", surname=" + surname + ", birthday=" + birthday + ", age=" + age + '}';
    }

}
