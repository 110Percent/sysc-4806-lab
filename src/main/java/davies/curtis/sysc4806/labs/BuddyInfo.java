package davies.curtis.sysc4806.labs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class BuddyInfo implements Serializable {
    private String name;
    private String phoneNumber;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public BuddyInfo() {

    }

    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
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
    public String toString() {
        return "BuddyInfo [name=" + this.name + ", phoneNumber=" + this.phoneNumber + "]";
    }

    public String getContext() {
        return this.name + " - " + this.phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
