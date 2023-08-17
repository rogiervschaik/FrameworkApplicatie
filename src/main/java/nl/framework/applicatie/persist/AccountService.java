package nl.framework.applicatie.persist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.framework.applicatie.domein.Account;

@Service
public class AccountService {

    @Autowired
    private AccountRepository ar;

    public Iterable<Account> vindAlleAccounts() {
        return ar.findAll();
    }

    public Account saveAccount(Account account) {
        return ar.save(account);
    }

    public Account updateAccount(Account account) {
        return ar.save(account);
    }

    public void deleteAccount(Long id) {
        ar.deleteById(id);
    }

    public Account getAccountById(Long id) {
        return ar.findById(id).orElse(null);
    }

}