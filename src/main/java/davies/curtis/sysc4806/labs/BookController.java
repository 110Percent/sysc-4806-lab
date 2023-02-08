package davies.curtis.sysc4806.labs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    AddressBookRepository repository;

    @GetMapping("/addressbook")
    public AddressBook addressBook(@RequestParam(value = "id", defaultValue = "1") Integer id) {
        return repository.findById(id.longValue());
    }
}
