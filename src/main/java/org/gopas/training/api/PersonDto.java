package org.gopas.training.api;

import java.time.LocalDate;

/**
 *
 * @author Seda
 */
public class PersonDto {
    
    private Long idPerson;
    private String email;
    private char[] pwd;
    private String nickname;
    private String firstName;
    private String surname;
    private LocalDate birthday;
    private Integer age;

    public PersonDto(){}
    
    public PersonDto(Long idPerson, String email, char[] pwd, String nickname, String firstName, String surname, LocalDate birthday, Integer age) {
        this.idPerson = idPerson;
        this.email = email;
        this.pwd = pwd;
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

    public char[] getPwd() {
        return pwd;
    }

    public void setPwd(char[] pwd) {
        this.pwd = pwd;
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
        return "PersonDto{" + "idPerson=" + idPerson + ", email=" + email + ", pwd=" + pwd + ", nickname=" + nickname + ", firstName=" + firstName + ", surname=" + surname + ", birthday=" + birthday + ", age=" + age + '}';
    }  

}
