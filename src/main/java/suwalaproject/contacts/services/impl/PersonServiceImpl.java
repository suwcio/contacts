package suwalaproject.contacts.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suwalaproject.contacts.dao.PersonRepository;
import suwalaproject.contacts.entities.Person;
import suwalaproject.contacts.services.PersonService;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person findPersonById(Long id) {
        return personRepository.findPersonById(id);
    }

    @Override
    public List<Person> findPersonByFirstname(String firstname) {
        return personRepository.findPersonByFirstname(firstname);
    }

    @Override
    public List<Person> findPersonByLastname(String lastname) {
        return personRepository.findPersonByLastname(lastname);
    }

    @Override
    public List<Person> findPersonBySex(Character sex) {
        return personRepository.findPersonBySex(sex);
    }

    @Override
    public void createPerson(Person person) {
        personRepository.createPerson(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deletePerson(id);
    }
}
