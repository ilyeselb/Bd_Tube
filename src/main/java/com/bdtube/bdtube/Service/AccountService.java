package com.bdtube.bdtube.Service;

import com.bdtube.bdtube.Model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public List<Account> getAll();
    public void addAccount(Account account);
    public void deleteAccount(int id);
    public Optional<Account> getaccountByid(int id);
    public void updateAccount(Account account);
}
