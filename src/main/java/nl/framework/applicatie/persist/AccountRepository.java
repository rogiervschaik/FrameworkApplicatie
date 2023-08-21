package nl.framework.applicatie.persist;

import nl.framework.applicatie.domein.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

   /*  Account findByUsername(String username);

    Account findPassword(String password); */
}
