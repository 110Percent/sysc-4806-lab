package davies.curtis.sysc4806.labs;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class AddressBook implements Serializable {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Collection<BuddyInfo> buddies;
    @Id
    @GeneratedValue
    private Long id;

    public AddressBook() {
        this.buddies = new ArrayList<>();
    }

    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        book.addBuddy(new BuddyInfo("Joe Mama", "1234567890"));
        book.addBuddy(new BuddyInfo("Hugh Janus", "6135831042"));
        book.addBuddy(new BuddyInfo("Wayne Curr", "1234567890"));
        book.addBuddy(new BuddyInfo("Hugh Mungus", "1234567890"));
        System.out.println(book);
    }

    public Collection<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(Collection<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Add an existing buddy to the address book
     *
     * @param buddy BuddyInfo with buddy to be added
     */
    public void addBuddy(BuddyInfo buddy) {
        this.buddies.add(buddy);
    }

    /**
     * Returns a string with a list of names and phone numbers in the address book
     *
     * @return String containing all names and phone numbers
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Name \t - \t Phone Number\n");
        for (BuddyInfo buddy : this.buddies) {
            builder.append(buddy.getContext()).append("\n");
        }
        return builder.toString();
    }

    /**
     * Get a buddy from an index in the address book's list
     *
     * @param i Index to retrieve the buddy from
     * @return Retrieved buddy
     */
    public BuddyInfo getBuddy(int i) {
        return (BuddyInfo) this.buddies.toArray()[i];
    }

}
