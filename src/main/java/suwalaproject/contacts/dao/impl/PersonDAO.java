package suwalaproject.contacts.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import suwalaproject.contacts.dao.PersonRepository;
import suwalaproject.contacts.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PersonDAO implements PersonRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Person findPersonById(Long id) {
        TypedQuery<Person> query = entityManager.createNamedQuery("Person.findById", Person.class).setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Person> findPersonByFirstname(String firstname) {
        TypedQuery<Person> query = entityManager.createNamedQuery("Person.findByFirstname", Person.class).setParameter("firstname", firstname);
        return query.getResultList();
    }

    @Override
    public List<Person> findPersonByLastname(String lastname) {
        TypedQuery<Person> query = entityManager.createNamedQuery("Person.findByLastname", Person.class).setParameter("lastname", lastname);
        return query.getResultList();
    }

    @Override
    public List<Person> findPersonBySex(Character sex) {
        TypedQuery<Person> query = entityManager.createNamedQuery("Person.findBySex", Person.class).setParameter("sex", sex);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Person createPerson(Person person) {
        Person createdPerson = entityManager.merge(person);
        return createdPerson;
    }

    @Override
    @Transactional
    public void deletePerson(Long id) {
        Person person = findPersonById(id);
        entityManager.remove(person);
    }
}
