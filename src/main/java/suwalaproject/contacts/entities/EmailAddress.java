package suwalaproject.contacts.entities;

import javax.persistence.*;

@Entity
public class EmailAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email_address")
    private String emailAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public EmailAddress(){

    }

    public EmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailAddress)) return false;

        EmailAddress that = (EmailAddress) o;

        if (!id.equals(that.id)) return false;
        return emailAddress.equals(that.emailAddress);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + emailAddress.hashCode();
        return result;
    }
}
