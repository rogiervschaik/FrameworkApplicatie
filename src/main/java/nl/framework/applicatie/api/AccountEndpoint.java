package nl.framework.applicatie.api;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.framework.applicatie.domein.Account;
import nl.framework.applicatie.dto.LoginRequestDto;
import nl.framework.applicatie.persist.AccountService;

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
    	Account account = this.as.getAccountById(id);
    	if (account == null)
    		return null;
    	
    	if (StringUtils.hasLength(updatedAccount.getEmail()))
    		account.setEmail(updatedAccount.getEmail());
    	if (StringUtils.hasLength(updatedAccount.getPassword()))
    		account.setPassword(updatedAccount.getPassword());
    	if (StringUtils.hasLength(updatedAccount.getGender()))
    		account.setGender(updatedAccount.getGender());
    	if (StringUtils.hasLength(updatedAccount.getNaam()))
    		account.setNaam(updatedAccount.getNaam());

    	account.setLeeftijd(updatedAccount.getLeeftijd());

        return as.updateAccount(account);
    }

    @GetMapping("api/findaccounts/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return as.getAccountById(id);
    }


    @DeleteMapping("api/deleteaccounts/{id}")
    public void deleteAccount(@PathVariable Long id) {
        as.deleteAccount(id);
    }

    @GetMapping("/api/account/current")
    public Account deleteAccount(HttpServletRequest request) {
        return (Account)request.getAttribute("AUTH");
    }

    @PostMapping("/api/account/login")
    public String login(@RequestBody LoginRequestDto dto) {
    	Account account = this.as.login(dto.getEmail(), dto.getPassword());
    	if (account == null) {
    		return null;
    	}

    	return account.getToken();
    }

}
