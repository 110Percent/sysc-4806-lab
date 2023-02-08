package davies.curtis.sysc4806.labs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LabApplication {

    private static final Logger log = LoggerFactory.getLogger(LabApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LabApplication.class, args);
    }

    @Bean
    public CommandLineRunner lab3(AddressBookRepository bookRepository, BuddyInfoRepository buddyRepository) {
        return (args) -> {
            AddressBook book = new AddressBook();
            // save a few customers
            book.addBuddy(new BuddyInfo("Hugh Janus", "1234567890"));
            book.addBuddy(new BuddyInfo("Jacques Strappe", "3216540987"));
            book.addBuddy(new BuddyInfo("Moe Ron", "6137371111"));
            book.addBuddy(new BuddyInfo("Tessa Teaquill", "6133825968"));
            book.addBuddy(new BuddyInfo("Mike Rotch", "6136136136"));

            bookRepository.save(book);

            // fetch all customers
            log.info("Address Books found with findAll():");
            log.info("------------------------------");
            for (AddressBook addressBook : bookRepository.findAll()) {
                log.info(addressBook.toString());
            }
            log.info("");

            // fetch an individual address book by ID
            AddressBook addressBook = bookRepository.findById(1L);
            log.info("Address Book found with findById(1L):");
            log.info("--------------------------------");
            log.info(addressBook.toString());
            log.info("");

            log.info("");
        };
    }

}
