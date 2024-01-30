package com.workintech.library.persons;

import com.workintech.library.enums.PersonRoles;

public abstract class Person {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;

    private PersonRoles personRoles;

    public Person(String name, String surname, String phoneNumber, String email,PersonRoles personRoles) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.personRoles=personRoles;
    }

    public Person(String name, String surname, PersonRoles personRoles) {
        this.name = name;
        this.surname = surname;
        this.personRoles = personRoles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonRoles getPersonRoles() {
        return personRoles;
    }

    public void setPersonRoles(PersonRoles personRoles) {
        this.personRoles = personRoles;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", personRoles=" + personRoles +
                '}';
    }
}
