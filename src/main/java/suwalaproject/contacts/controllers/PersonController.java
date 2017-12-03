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

    @RequestMapping(value = "findPersonById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Person findPersonById(@PathVariable("id") Long id){
        return personService.findPersonById(id);
    }

    @RequestMapping(value = "findPersonByFirstname/{firstname}", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> findPersonByFirstname(@PathVariable("firstname") String firstname){
        return personService.findPersonByFirstname(firstname);
    }
}
