package suwalaproject.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Person> findPersonById(@PathVariable("id") Long id){
        Person person = personService.findPersonById(id);
        if (person == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(person);
        }
    }

    @RequestMapping(value = PersonRestURIConstants.FIND_PERSON_BY_FIRSTNAME, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Person>> findPersonByFirstname(@PathVariable("firstname") String firstname){
        List<Person> persons = personService.findPersonByFirstname(firstname);
        if (persons == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(persons);
        }
    }

    @RequestMapping(value = PersonRestURIConstants.FIND_PERSON_BY_LASTNAME, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Person>> findPersonByLastname(@PathVariable("lastname") String lastname){
        List<Person> persons = personService.findPersonByLastname(lastname);
        if (persons == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(persons);
        }
    }

    @RequestMapping(value = PersonRestURIConstants.FIND_PERSON_BY_SEX, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Person>> findPersonBySex(@PathVariable("sex") Character sex){
        List<Person> persons = personService.findPersonBySex(sex);
        if (persons == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(persons);
        }
    }

    @RequestMapping(value = PersonRestURIConstants.FIND_ALL, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Person>> findAll(){
        List<Person> persons = personService.findAll();
        if (persons == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(persons);
        }
    }

    @RequestMapping(value = PersonRestURIConstants.CREATE_PERSON, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person createdPerson = personService.createPerson(person);
        return ResponseEntity.ok().body(createdPerson);
    }

    @RequestMapping(value = PersonRestURIConstants.DELETE_PERSON, method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Person> deletePerson(@PathVariable("id") Long id){
        personService.deletePerson(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = PersonRestURIConstants.EDIT_PERSON, method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Person> editPerson(@RequestBody Person person){
        Person editedPerson = personService.editPerson(person);
        return ResponseEntity.ok().body(editedPerson);
    }
}
