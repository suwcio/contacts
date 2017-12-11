package suwalaproject.contacts.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suwalaproject.contacts.dao.PersonRepository;
import suwalaproject.contacts.entities.Address;
import suwalaproject.contacts.entities.EmailAddress;
import suwalaproject.contacts.entities.Person;
import suwalaproject.contacts.entities.PhoneNumber;
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
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person createPerson(Person person) {
        List<PhoneNumber> phoneNumbers = person.getPhoneNumbers();
        if (!phoneNumbers.isEmpty()){
            for (PhoneNumber phoneNumber : phoneNumbers){
                phoneNumber.setPerson(person);
            }
            person.setPhoneNumbers(phoneNumbers);
        }

        List<Address> addresses = person.getAddresses();
        if (!addresses.isEmpty()){
            for (Address address : addresses){
                address.setPerson(person);
            }
            person.setAddresses(addresses);
        }

        List<EmailAddress> emailAddresses = person.getEmailAddresses();
        if (!emailAddresses.isEmpty()){
            for (EmailAddress emailAddress : emailAddresses){
                emailAddress.setPerson(person);
            }
            person.setEmailAddresses(emailAddresses);
        }

        Person createdPerson = personRepository.save(person);
        return createdPerson;
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.delete(id);
    }

    @Override
    public Person editPerson(Person person) {
        Person personFromDatabase = personRepository.findPersonById(person.getId());
        if (!personFromDatabase.getFirstname().equals(person.getFirstname())){
            personFromDatabase.setFirstname(person.getFirstname());
        }

        if (!personFromDatabase.getLastname().equals(person.getLastname())){
            personFromDatabase.setLastname(person.getLastname());
        }

        if (!personFromDatabase.getSex().equals(person.getSex())){
            personFromDatabase.setSex(person.getSex());
        }

        if (!personFromDatabase.getPhoneNumbers().equals(person.getPhoneNumbers())){
            personFromDatabase.setPhoneNumbers(person.getPhoneNumbers());
        }

        if (!personFromDatabase.getAddresses().equals(person.getAddresses())){
            personFromDatabase.setAddresses(person.getAddresses());
        }

        if (!personFromDatabase.getEmailAddresses().equals(person.getEmailAddresses())){
            personFromDatabase.setEmailAddresses(person.getEmailAddresses());
        }

        return personRepository.save(personFromDatabase);
    }

}
