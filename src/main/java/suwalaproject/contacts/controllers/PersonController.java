package suwalaproject.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import suwalaproject.contacts.entities.Person;
import suwalaproject.contacts.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = PersonRestURIConstants.FIND_PERSON_BY_ID, method = RequestMethod.GET)
    @ResponseBody
    public Person findPersonById(@PathVariable("id") Long id){
        return personService.findPersonById(id);
    }

    @RequestMapping(value = PersonRestURIConstants.FIND_PERSON_BY_FIRSTNAME, method = RequestMethod.GET)
    @ResponseBody
    public List<Person> findPersonByFirstname(@PathVariable("firstname") String firstname){
        return personService.findPersonByFirstname(firstname);
    }

    @RequestMapping(value = PersonRestURIConstants.FIND_PERSON_BY_LASTNAME, method = RequestMethod.GET)
    @ResponseBody
    public List<Person> findPersonByLastname(@PathVariable("lastname") String lastname){
        return personService.findPersonByLastname(lastname);
    }

    @RequestMapping(value = PersonRestURIConstants.FIND_PERSON_BY_SEX, method = RequestMethod.GET)
    @ResponseBody
    public List<Person> findPersonBySex(@PathVariable("sex") Character sex){
        return personService.findPersonBySex(sex);
    }

    @RequestMapping(value = PersonRestURIConstants.CREATE_PERSON, method = RequestMethod.POST)
    @ResponseBody
    public Person createPerson(@RequestBody Person person){
        Person createdPerson = personService.createPerson(person);
        return createdPerson;
    }

    @RequestMapping(value = PersonRestURIConstants.DELETE_PERSON, method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePerson(@PathVariable("id") Long id){
        personService.deletePerson(id);
    }

    @RequestMapping(value = PersonRestURIConstants.EDIT_PERSON, method = RequestMethod.PUT)
    @ResponseBody
    public Person editPerson(@RequestBody Person person){
        return personService.editPerson(person);
    }
}
