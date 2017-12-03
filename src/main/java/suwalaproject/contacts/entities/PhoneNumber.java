package suwalaproject.contacts.entities;

import javax.persistence.*;

@Entity
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public PhoneNumber(){

    }

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;

        PhoneNumber that = (PhoneNumber) o;

        if (!id.equals(that.id)) return false;
        if (!phoneNumber.equals(that.phoneNumber)) return false;
        return person.equals(that.person);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + person.hashCode();
        return result;
    }
}
