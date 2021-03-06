package suwalaproject.contacts.services;

import org.springframework.stereotype.Service;
import suwalaproject.contacts.entities.Person;

import java.util.List;

@Service
public interface PersonService {

    Person findPersonById(Long id);
    List<Person> findPersonByFirstname(String firstname);
    List<Person> findPersonByLastname(String lastname);
    List<Person> findPersonBySex(Character sex);
    List<Person> findAll();

    Person createPerson(Person person);
    void deletePerson(Long id);
    Person editPerson(Person person);
}
