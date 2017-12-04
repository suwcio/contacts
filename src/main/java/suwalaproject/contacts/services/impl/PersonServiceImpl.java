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

        Person createdPerson = personRepository.createPerson(person);
        return createdPerson;
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deletePerson(id);
    }
}
