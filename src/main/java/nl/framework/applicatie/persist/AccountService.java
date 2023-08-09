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


    // public class AccountService {
    //
    //    private final Map<Long, Account> accountsMap = new HashMap<>();
    //    private final AtomicLong accountIdGenerator = new AtomicLong(1);
    //
    //    public Iterable<Account> vindAlleAccounts() {
    //        return accountsMap.values();
    //    }
    //
    //    public Account saveAccount(Account account) {
    //        long newId = accountIdGenerator.getAndIncrement();
    //        account.setId(newId);
    //        accountsMap.put(newId, account);
    //        return account;
    //    }
    //
    //    public Account updateAccount(Long id, Account updatedAccount) {
    //        if (accountsMap.containsKey(id)) {
    //            updatedAccount.setId(id);
    //            accountsMap.put(id, updatedAccount);
    //            return updatedAccount;
    //        }
    //        return null;
    //    }
    //
    //    public Account getAccountById(Long id) {
    //        return accountsMap.get(id);
    //    }
    //
    //    public void deleteAccount(Long id) {
    //        accountsMap.remove(id);
    //    }
    //b
}
