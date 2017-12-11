package suwalaproject.contacts.services;

import suwalaproject.contacts.entities.Address;

import java.util.List;

public interface AddressService {

    Address findAddressById(Long id);
    List<Address> findAddressByCode(String code);
    List<Address> findAddressByStreet(String street);
    List<Address> findAddressByBlockNumber(String blockNumber);
    List<Address> findAddressByApartmentNumber(String apartmentNumber);
    List<Address> findAddressByCity(String city);
    List<Address> findAddressByCountry(String country);
    List<Address> findAll();

    Address createAddress(Address address);
    void deleteAddress(Long id);
    Address editAddress(Address address);
}
