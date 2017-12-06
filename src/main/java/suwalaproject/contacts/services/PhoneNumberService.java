package suwalaproject.contacts.services;

import suwalaproject.contacts.entities.PhoneNumber;

public interface PhoneNumberService {

    PhoneNumber findPhoneNumberById(Long id);
    PhoneNumber findPhoneNumberByPhoneNumber(String phoneNumber);

    PhoneNumber createPhoneNumber(PhoneNumber phoneNumber);
    void deletePhoneNumber(Long id);
    PhoneNumber editPhoneNumber(PhoneNumber phoneNumber);
}
