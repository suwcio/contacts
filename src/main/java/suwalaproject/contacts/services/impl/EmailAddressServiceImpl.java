package suwalaproject.contacts.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suwalaproject.contacts.dao.EmailAddressRepository;
import suwalaproject.contacts.entities.EmailAddress;
import suwalaproject.contacts.services.EmailAddressService;

import java.util.List;

@Service
public class EmailAddressServiceImpl implements EmailAddressService {

    @Autowired
    EmailAddressRepository emailAddressRepository;

    @Override
    public EmailAddress findEmailAddressById(Long id) {
        return emailAddressRepository.findEmailAddressById(id);
    }

    @Override
    public EmailAddress findEmailAddressByEmailAddress(String emailAddress) {
        return emailAddressRepository.findEmailAddressByEmailAddress(emailAddress);
    }

    @Override
    public List<EmailAddress> findAll() {
        return (List<EmailAddress>) emailAddressRepository.findAll();
    }

    @Override
    public EmailAddress createEmailAddress(EmailAddress emailAddress) {
        return emailAddressRepository.save(emailAddress);
    }

    @Override
    public void deleteEmailAddress(Long id) {
        emailAddressRepository.delete(id);
    }

    @Override
    public EmailAddress editEmailAddress(EmailAddress emailAddress) {
        EmailAddress emailAddressFromDatabase = emailAddressRepository.findEmailAddressById(emailAddress.getId());
        if (!emailAddressFromDatabase.getEmailAddress().equals(emailAddress.getEmailAddress())){
            emailAddressFromDatabase.setEmailAddress(emailAddress.getEmailAddress());
        }

        return emailAddressRepository.save(emailAddressFromDatabase);
    }
}
