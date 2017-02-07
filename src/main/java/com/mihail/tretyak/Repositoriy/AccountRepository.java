package com.mihail.tretyak.Repositoriy;

import com.mihail.tretyak.Model.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;

@Repository
public interface AccountRepository {

    HashMap<String, Account> getAllAccounts();

    public Account getAccount(String email);

    public boolean addAccount(Account account);

    public boolean deleteAccount(Account account);

    public boolean deleteAccount(String email);
}
