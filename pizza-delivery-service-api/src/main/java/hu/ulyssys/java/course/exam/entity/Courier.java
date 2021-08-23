package hu.ulyssys.java.course.exam.entity;

import javax.persistence.*;
import java.util.Objects;


@NamedQuery(name = Courier.FIND_BY_NAME, query = "select u from Courier u where u.firstName=:firstName")
@Entity
@Table
public class Courier extends AbstractPizza{
    public static final String FIND_BY_NAME = "Courier.findByName";

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="phone_number")
    private String phoneNumber;




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        if (o == null || getClass() != o.getClass()) return false;

        Courier courier = (Courier) o;

        if (getId() != null ? !getId().equals(courier.getId()) : courier.getId() != null) return false;
        return firstName != null ? firstName.equals(courier.firstName) : courier.firstName == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }
}
