package suwalaproject.contacts.dao;

import org.springframework.data.repository.CrudRepository;
import suwalaproject.contacts.entities.Address;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {

    Address findAddressById(Long id);
    List<Address> findAddressByCode(String code);
    List<Address> findAddressByStreet(String street);
    List<Address> findAddressByBlockNumber(String blockNumber);
    List<Address> findAddressByApartmentNumber(String apartmentNumber);
    List<Address> findAddressByCity(String city);
    List<Address> findAddressByCountry(String country);
}
