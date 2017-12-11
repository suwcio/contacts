package suwalaproject.contacts.services;

import suwalaproject.contacts.entities.PhoneNumber;

import java.util.List;

public interface PhoneNumberService {

    PhoneNumber findPhoneNumberById(Long id);
    PhoneNumber findPhoneNumberByPhoneNumber(String phoneNumber);
    List<PhoneNumber> findAll();

    PhoneNumber createPhoneNumber(PhoneNumber phoneNumber);
    void deletePhoneNumber(Long id);
    PhoneNumber editPhoneNumber(PhoneNumber phoneNumber);
}
