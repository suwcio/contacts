package suwalaproject.contacts.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suwalaproject.contacts.dao.PhoneNumberRepository;
import suwalaproject.contacts.entities.PhoneNumber;
import suwalaproject.contacts.services.PhoneNumberService;

import java.util.List;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Override
    public PhoneNumber findPhoneNumberById(Long id) {
        return phoneNumberRepository.findPhoneNumberById(id);
    }

    @Override
    public PhoneNumber findPhoneNumberByPhoneNumber(String phoneNumber) {
        return phoneNumberRepository.findPhoneNumberByPhoneNumber(phoneNumber);
    }

    @Override
    public List<PhoneNumber> findAll() {
        return (List<PhoneNumber>) phoneNumberRepository.findAll();
    }

    @Override
    public PhoneNumber createPhoneNumber(PhoneNumber phoneNumber) {
        return phoneNumberRepository.save(phoneNumber);
    }

    @Override
    public void deletePhoneNumber(Long id) {
        phoneNumberRepository.delete(id);
    }

    @Override
    public PhoneNumber editPhoneNumber(PhoneNumber phoneNumber) {
        PhoneNumber phoneNumberFromDatabase = phoneNumberRepository.findPhoneNumberById(phoneNumber.getId());
        if (!phoneNumberFromDatabase.getPhoneNumber().equals(phoneNumber.getPhoneNumber())) {
            phoneNumberFromDatabase.setPhoneNumber(phoneNumber.getPhoneNumber());
        }
        return phoneNumberRepository.save(phoneNumberFromDatabase);
    }
}
