package nl.framework.applicatie.persist;

import java.util.Optional;
import java.util.Random;

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

    public Account getAccountByToken(String token) {
    	Optional<Account> optionalAccount = this.ar.findByToken(token);

    	if (optionalAccount.isEmpty()) {
    		return null;
    	}

    	return optionalAccount.get();
    }
    
    public Account login(String email, String password) {
    	Optional<Account> optionalAccount = this.ar.findByEmailAndPassword(email, password);

    	if (optionalAccount.isEmpty()) {
    		return null;
    	}

    	Account account = optionalAccount.get();
    	account.setToken(generateRandomToken());
    	ar.save(account);

    	return account;
    }

    private String generateRandomToken() {
    	return new Random().ints(48, 122).filter(i -> (i < 58 || i > 64) && (i < 91 || i > 96)).limit(90).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

}