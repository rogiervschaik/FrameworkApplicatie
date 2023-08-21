package nl.framework.applicatie.api;


import nl.framework.applicatie.domein.Account;
import nl.framework.applicatie.persist.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountEndpoint {

    @Autowired
    private AccountService as;

    @GetMapping("api/accounts")
    public Iterable<Account> methodeVindAccounts() {
        return as.vindAlleAccounts();
    }

    @PostMapping("api/saveaccounts")
    public Account saveAccount(@RequestBody Account account) {
        return as.saveAccount(account);
    }

    @PutMapping("api/updateaccounts/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody Account updatedAccount) {
        return as.updateAccount(updatedAccount);
    }

    @GetMapping("api/findaccounts/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return as.getAccountById(id);
    }

    /* @GetMapping("api/findaccount/{username}")
    public Account getAccountByUsername(@PathVariable String username) {
        return as.getAccountByUsername(username);
    }

    @GetMapping("api/findaccount/{password}")
    public Account getPassword(@PathVariable String password) {
        return as.gePassword(password);
    }

    @GetMapping("api/findaccount/{username}/{password}")
    public Account authenticate(@PathVariable String username, String password) {
        return as.getAccountByUsername(username).getPassword(password);
    }
    */

    @DeleteMapping("api/deleteaccounts/{id}")
    public void deleteAccount(@PathVariable Long id) {
        as.deleteAccount(id);
    }
}
