package nl.framework.applicatie.api;


import nl.framework.applicatie.domein.Account;
import nl.framework.applicatie.persist.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountEndpoint {

    @Autowired
    private AccountService as;

    @GetMapping ("accounts")
    public Iterable<Account> methodeVindAccounts() {
        return as.vindAlleAccounts();
    }
}
