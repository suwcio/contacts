package suwalaproject.contacts.dao;

import suwalaproject.contacts.entities.Person;

import java.util.List;

public interface PersonRepository {

    Person findPersonById(Long id);
    List<Person> findPersonByFirstname(String firstname);
    List<Person> findPersonByLastname(String lastname);
    List<Person> findPersonBySex(Character sex);

    Person createPerson(Person person);
    void deletePerson(Long id);
}
