package suwalaproject.contacts.services;

import suwalaproject.contacts.entities.EmailAddress;

import java.util.List;

public interface EmailAddressService {

    EmailAddress findEmailAddressById(Long id);
    EmailAddress findEmailAddressByEmailAddress(String emailAddress);
    List<EmailAddress> findAll();

    EmailAddress createEmailAddress(EmailAddress emailAddress);
    void deleteEmailAddress(Long id);
    EmailAddress editEmailAddress(EmailAddress emailAddress);
}
