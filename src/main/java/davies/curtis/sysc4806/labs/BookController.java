package davies.curtis.sysc4806.labs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    AddressBookRepository addressBookRepository;
    @Autowired
    BuddyInfoRepository buddyInfoRepository;

    @GetMapping("/addressbook/{id}")
    public AddressBook addressBook(@PathVariable long id) {
        return addressBookRepository.findById(id);
    }

    @DeleteMapping("/addressbook/{id}")
    public void deleteAddressBook(@PathVariable long id) {
        addressBookRepository.deleteById(id);
    }

    @PostMapping("/addressbook/new")
    public AddressBook postAddressBook(@RequestBody AddressBook addressBook) {
        return addressBookRepository.save(addressBook);
    }

    @PostMapping("/addressbook/{id}/buddies")
    public AddressBook putBuddyAddressBook(@PathVariable long id, @RequestBody BuddyInfo buddyInfo) {
        AddressBook book = addressBookRepository.findById(id);
        book.addBuddy(buddyInfo);
        buddyInfoRepository.save(buddyInfo);
        addressBookRepository.save(book);
        return book;
    }

    @GetMapping("/addressbook/{bookId}/buddies/{buddyId}")
    public BuddyInfo getBuddy(@PathVariable long bookId, @PathVariable int buddyId) {
        AddressBook book = addressBookRepository.findById(bookId);
        return book.getBuddy(buddyId - 1);
    }

}
