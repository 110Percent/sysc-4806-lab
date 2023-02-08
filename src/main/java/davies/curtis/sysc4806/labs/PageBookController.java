package davies.curtis.sysc4806.labs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;


@Controller

public class PageBookController {

    @Autowired
    AddressBookRepository repository;

    @GetMapping("/addressbookpage")
    public String addressBookPage(@RequestParam(value = "id", defaultValue = "1") Integer id, Model model) {
        model.addAttribute("id", id);

        AddressBook addressBook = repository.findById(id.longValue());
        model.addAttribute("buddies", addressBook.getBuddies().toArray());

        return "addressbook";
    }
}
