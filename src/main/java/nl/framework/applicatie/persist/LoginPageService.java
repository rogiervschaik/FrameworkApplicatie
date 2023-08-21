/* package nl.framework.applicatie.persist;

import nl.framework.applicatie.domein.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginPageService {

    @Autowired
    private AccountRepository accountRepository;

    public boolean authenticate(String username, String password) {
        // Find the account by username
        Account account = accountRepository.findByUsername(username);

        if (account != null && account.getPassword().equals(password)) {
            return true; // Authentication successful
        } else {
            return false; // Authentication failed
        }
    }
} */
