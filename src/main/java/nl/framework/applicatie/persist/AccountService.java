package nl.framework.applicatie.persist;

import nl.framework.applicatie.domein.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository ar;
    public Iterable<Account> vindAlleAccounts(){
        return ar.findAll();
    }

    public Account opslaanAccount(Account account){
        return ar.save(account);
    }

    public void verwijderAccount(Account account) {
        ar.delete(account);
    }


    // update methode al verwerkt in opsla methode

}
