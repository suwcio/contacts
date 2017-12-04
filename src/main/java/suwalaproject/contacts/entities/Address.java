package suwalaproject.contacts.entities;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "street")
    private String street;

    @Column(name = "block_number")
    private String blockNumber;

    @Column(name = "apartment_number")
    private String apartmentNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public Address(){

    }

    public Address(String code, String street, String blockNumber, String apartmentNumber, String city, String country){
        this.code = code;
        this.street = street;
        this.blockNumber = blockNumber;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (!id.equals(address.id)) return false;
        if (!code.equals(address.code)) return false;
        if (!street.equals(address.street)) return false;
        if (!blockNumber.equals(address.blockNumber)) return false;
        if (!apartmentNumber.equals(address.apartmentNumber)) return false;
        if (!city.equals(address.city)) return false;
        return country.equals(address.country);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + code.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + blockNumber.hashCode();
        result = 31 * result + apartmentNumber.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }
}
