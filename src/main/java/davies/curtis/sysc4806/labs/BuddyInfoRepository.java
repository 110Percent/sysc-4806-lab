package davies.curtis.sysc4806.labs;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer> {
    BuddyInfo findById(int id);

}
