package suwalaproject.contacts.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries(
        {@NamedQuery(name = "Person.findById", query = "select p from Person p where p.id = :id"),
        @NamedQuery(name = "Person.findByFirstname", query = "select p from Person p where p.firstname = :firstname"),
        @NamedQuery(name = "Person.findByLastname", query = "select p from Person p where p.lastname = :lastname"),
        @NamedQuery(name = "Person.findBySex", query = "select p from Person p where p.sex = :sex")})
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "sex")
    private Character sex;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<PhoneNumber> phoneNumbers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<EmailAddress> emailAddresses;

    public Person(){

    }

    public Person(String firstname, String lastname, Character sex, List<Address> addresses, List<EmailAddress> emailAddresses, List<PhoneNumber> phoneNumbers){
        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
        this.addresses = addresses;
        this.emailAddresses = emailAddresses;
        this.phoneNumbers = phoneNumbers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<EmailAddress> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<EmailAddress> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!id.equals(person.id)) return false;
        if (!firstname.equals(person.firstname)) return false;
        if (!lastname.equals(person.lastname)) return false;
        return sex.equals(person.sex);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + sex.hashCode();
        return result;
    }
}
