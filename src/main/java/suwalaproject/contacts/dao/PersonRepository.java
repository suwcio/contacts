package suwalaproject.contacts.dao;

import org.springframework.data.repository.CrudRepository;
import suwalaproject.contacts.entities.Person;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findPersonById(Long id);
    List<Person> findPersonByFirstname(String firstname);
    List<Person> findPersonByLastname(String lastname);
    List<Person> findPersonBySex(Character sex);
}
