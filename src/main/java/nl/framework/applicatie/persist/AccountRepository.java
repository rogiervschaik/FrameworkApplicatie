package nl.framework.applicatie.persist;

import nl.framework.applicatie.domein.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AccountRepository extends CrudRepository<Account, Long> {

}