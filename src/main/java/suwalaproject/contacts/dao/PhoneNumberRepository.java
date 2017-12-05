package suwalaproject.contacts.dao;

import org.springframework.data.repository.CrudRepository;
import suwalaproject.contacts.entities.PhoneNumber;

public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Long> {

    PhoneNumber findPhoneNumberById(Long id);
    PhoneNumber findPhoneNumberByPhoneNumber(String phoneNumber);
}
