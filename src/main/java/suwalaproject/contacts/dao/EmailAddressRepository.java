package suwalaproject.contacts.dao;

import org.springframework.data.repository.CrudRepository;
import suwalaproject.contacts.entities.EmailAddress;

public interface EmailAddressRepository extends CrudRepository<EmailAddress, Long> {

    EmailAddress findEmailAddressById(Long id);
    EmailAddress findEmailAddressByEmailAddress(String emailAddress);
}
