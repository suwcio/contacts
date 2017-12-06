package suwalaproject.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import suwalaproject.contacts.entities.PhoneNumber;
import suwalaproject.contacts.services.PhoneNumberService;

@RestController
@RequestMapping("/phoneNumber")
public class PhoneNumberController {

    @Autowired
    PhoneNumberService phoneNumberService;

    @RequestMapping(value = PhoneNumberRestURIConstants.FIND_PHONE_NUMBER_BY_ID, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<PhoneNumber> findPhoneNumberById(@PathVariable("id") Long id){
        PhoneNumber phoneNumber = phoneNumberService.findPhoneNumberById(id);
        if (phoneNumber == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(phoneNumber);
    }

    @RequestMapping(value = PhoneNumberRestURIConstants.FIND_PHONE_NUMBER_BY_PHONE_NUMBER, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<PhoneNumber> findPhoneNumberByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber){
        PhoneNumber phoneNumber1 = phoneNumberService.findPhoneNumberByPhoneNumber(phoneNumber);
        if (phoneNumber1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(phoneNumber1);
    }

    @RequestMapping(value = PhoneNumberRestURIConstants.CREATE_PHONE_NUMBER, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<PhoneNumber> createPhoneNumber(@RequestBody PhoneNumber phoneNumber){
        PhoneNumber createdPhoneNumber = phoneNumberService.createPhoneNumber(phoneNumber);
        return ResponseEntity.ok().body(createdPhoneNumber);
    }

    @RequestMapping(value = PhoneNumberRestURIConstants.DELETE_PHONE_NUMBER, method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<PhoneNumber> deletePhoneNumber(@PathVariable Long id){
        phoneNumberService.deletePhoneNumber(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = PhoneNumberRestURIConstants.EDIT_PHONE_NUMBER, method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<PhoneNumber> editPhoneNumber(@RequestBody PhoneNumber phoneNumber){
        PhoneNumber createdPhoneNumber = phoneNumberService.editPhoneNumber(phoneNumber);
        return ResponseEntity.ok().body(createdPhoneNumber);
    }
}
