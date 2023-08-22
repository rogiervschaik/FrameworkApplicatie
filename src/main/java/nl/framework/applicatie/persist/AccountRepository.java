package nl.framework.applicatie.persist;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.framework.applicatie.domein.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

   Optional<Account> findByEmailAndPassword(String username, String password);

   Optional<Account> findByToken(String token);

}
