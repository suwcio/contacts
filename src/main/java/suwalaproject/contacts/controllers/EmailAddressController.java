package suwalaproject.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import suwalaproject.contacts.entities.EmailAddress;
import suwalaproject.contacts.services.EmailAddressService;

@RestController
@RequestMapping("/emailAddress")
public class EmailAddressController {

    @Autowired
    EmailAddressService emailAddressService;

    @RequestMapping(value = EmailAddressRestURIConstants.FIND_EMAIL_ADDRESS_BY_ID, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<EmailAddress> findEmailAddressById(@PathVariable("id") Long id){
        EmailAddress emailAddress = emailAddressService.findEmailAddressById(id);
        if (emailAddress == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(emailAddress);
        }
    }

    @RequestMapping(value = EmailAddressRestURIConstants.FIND_EMAIL_ADDRESS_BY_EMAIL_ADDRESS, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<EmailAddress> findEmailAddressByEmailAddress(@PathVariable("emailAddress") String emailAddress){
        EmailAddress emailAddress1 = emailAddressService.findEmailAddressByEmailAddress(emailAddress);
        if (emailAddress1 == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(emailAddress1);
        }
    }

    @RequestMapping(value = EmailAddressRestURIConstants.CREATE_EMAIL_ADDRESS, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<EmailAddress> createEmailAddress(@RequestBody EmailAddress emailAddress){
        EmailAddress createdEmailAddress = emailAddressService.createEmailAddress(emailAddress);
        return ResponseEntity.ok().body(createdEmailAddress);
    }

    @RequestMapping(value = EmailAddressRestURIConstants.DELETE_EMAIL_ADDRESS, method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<EmailAddress> deleteEmailAddress(@PathVariable Long id){
        emailAddressService.deleteEmailAddress(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = EmailAddressRestURIConstants.EDIT_EMAIL_ADDRESS, method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<EmailAddress> editEmailAddress(@RequestBody EmailAddress emailAddress){
        EmailAddress createdEmailAddress = emailAddressService.editEmailAddress(emailAddress);
        return ResponseEntity.ok().body(createdEmailAddress);
    }
}
