package suwalaproject.contacts.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suwalaproject.contacts.dao.AddressRepository;
import suwalaproject.contacts.entities.Address;
import suwalaproject.contacts.services.AddressService;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address findAddressById(Long id) {
        return addressRepository.findAddressById(id);
    }

    @Override
    public List<Address> findAddressByCode(String code) {
        return addressRepository.findAddressByCode(code);
    }

    @Override
    public List<Address> findAddressByStreet(String street) {
        return addressRepository.findAddressByStreet(street);
    }

    @Override
    public List<Address> findAddressByBlockNumber(String blockNumber) {
        return addressRepository.findAddressByBlockNumber(blockNumber);
    }

    @Override
    public List<Address> findAddressByApartmentNumber(String apartmentNumber) {
        return addressRepository.findAddressByApartmentNumber(apartmentNumber);
    }

    @Override
    public List<Address> findAddressByCity(String city) {
        return addressRepository.findAddressByCity(city);
    }

    @Override
    public List<Address> findAddressByCountry(String country) {
        return addressRepository.findAddressByCountry(country);
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.delete(id);
    }

    @Override
    public Address editAddress(Address address) {
        Address addressFromDatabase = addressRepository.findAddressById(address.getId());
        if (!addressFromDatabase.getApartmentNumber().equals(address.getApartmentNumber())){
            addressFromDatabase.setApartmentNumber(address.getApartmentNumber());
        }
        if (!addressFromDatabase.getBlockNumber().equals(address.getBlockNumber())){
            addressFromDatabase.setBlockNumber(address.getBlockNumber());
        }
        if (!addressFromDatabase.getCity().equals(address.getCity())){
            addressFromDatabase.setCity(address.getCity());
        }
        if (!addressFromDatabase.getCode().equals(address.getCode())){
            addressFromDatabase.setCode(address.getCode());
        }
        if (!addressFromDatabase.getCountry().equals(address.getCountry())){
            addressFromDatabase.setCountry(address.getCountry());
        }
        if (!addressFromDatabase.getStreet().equals(address.getStreet())){
            addressFromDatabase.setStreet(address.getStreet());
        }

        return addressRepository.save(addressFromDatabase);
    }
}
