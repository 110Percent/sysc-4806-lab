package davies.curtis.sysc4806.labs;


import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {


    AddressBook findById(long id);
}