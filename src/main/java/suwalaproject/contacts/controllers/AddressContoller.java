package suwalaproject.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import suwalaproject.contacts.entities.Address;
import suwalaproject.contacts.services.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressContoller {

    @Autowired
    AddressService addressService;

    @RequestMapping(value = AddressRestURIConstants.FIND_ADDRESS_BY_ID, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Address> findAddressById(@PathVariable("id") Long id){
        Address address = addressService.findAddressById(id);
        if (address == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(address);
        }
    }

    @RequestMapping(value = AddressRestURIConstants.FIND_ADDRESS_BY_CODE, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Address>> findAddressByCode(@PathVariable("code") String code){
        List<Address> addresses = addressService.findAddressByCode(code);
        if (addresses == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(addresses);
        }
    }

    @RequestMapping(value = AddressRestURIConstants.FIND_ADDRESS_BY_STREET, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Address>> findAddressByStreet(@PathVariable("street") String street){
        List<Address> addresses = addressService.findAddressByStreet(street);
        if (addresses == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(addresses);
        }
    }

    @RequestMapping(value = AddressRestURIConstants.FIND_ADDRESS_BY_BLOCK_NUMBER, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Address>> findAddressByBlockNumber(@PathVariable("blockNumber") String blockNumber){
        List<Address> addresses = addressService.findAddressByBlockNumber(blockNumber);
        if (addresses == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(addresses);
        }
    }

    @RequestMapping(value = AddressRestURIConstants.FIND_ADDRESS_BY_APARTMENT_NUMBER, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Address>> findAddressByApartmentNumber(@PathVariable("apartmentNumber") String apartmentNumber){
        List<Address> addresses = addressService.findAddressByApartmentNumber(apartmentNumber);
        if (addresses == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(addresses);
        }
    }

    @RequestMapping(value = AddressRestURIConstants.FIND_ADDRESS_BY_CITY, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Address>> findAddressByCity(@PathVariable("city") String city){
        List<Address> addresses = addressService.findAddressByCity(city);
        if (addresses == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(addresses);
        }
    }

    @RequestMapping(value = AddressRestURIConstants.FIND_ADDRESS_BY_COUNTRY, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Address>> findAddressByCountry(@PathVariable("country") String country){
        List<Address> addresses = addressService.findAddressByCountry(country);
        if (addresses == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(addresses);
        }
    }

    @RequestMapping(value = AddressRestURIConstants.FIND_ALL, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Address>> findAll(){
        List<Address> addresses = addressService.findAll();
        if (addresses == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(addresses);
        }
    }

    @RequestMapping(value = AddressRestURIConstants.CREATE_ADDRESS, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        Address createdAddress = addressService.createAddress(address);
        return ResponseEntity.ok().body(createdAddress);
    }

    @RequestMapping(value = AddressRestURIConstants.DELETE_ADDRESS, method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Address> deleteAddress(@PathVariable("id") Long id){
        addressService.deleteAddress(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = AddressRestURIConstants.EDIT_ADDRESS, method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Address> editAddress(@RequestBody Address address){
        Address editedAddress = addressService.editAddress(address);
        return ResponseEntity.ok().body(editedAddress);
    }
}
