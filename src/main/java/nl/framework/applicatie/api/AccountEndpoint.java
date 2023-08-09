package nl.framework.applicatie.api;


import nl.framework.applicatie.domein.Account;
import nl.framework.applicatie.persist.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountEndpoint {

    @Autowired
    private AccountService as;

    @GetMapping ("accounts")
    public Iterable<Account> methodeVindAccounts() {
        return as.vindAlleAccounts();
    }
    @PostMapping("accounts")
    public Account saveAccount(@RequestBody Account account) {
        return as.saveAccount(account);
    }

    @PutMapping("accounts/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody Account updatedAccount) {
        return as.updateAccount(id, updatedAccount);
    }

    @GetMapping("accounts/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return as.getAccountById(id);
    }

    @DeleteMapping("accounts/{id}")
    public void deleteAccount(@PathVariable Long id) {
        as.deleteAccount(id);
    }
}
