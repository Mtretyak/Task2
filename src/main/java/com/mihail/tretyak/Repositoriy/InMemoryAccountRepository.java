package com.mihail.tretyak.Repositoriy;

import com.mihail.tretyak.Model.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class InMemoryAccountRepository implements AccountRepository {

    private HashMap<String, Account> accounts = new HashMap<>();

    @Override
    public HashMap<String, Account> getAllAccounts() {
        return this.accounts;
    }

    @Override
    public Account getAccount(String email) {
        return accounts.get(email);
    }

    @Override
    public boolean addAccount(Account account) {
        if (accounts.get(account.getEmail()) != null) {
            return false;
        }
        accounts.put(account.getEmail(), account);
        return true;
    }

    @Override
    public boolean deleteAccount(Account account) {
        if (accounts.remove(account.getEmail()) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAccount(String email) {
        if (accounts.remove(email) != null) {
            return true;
        }
        return false;
    }
}
