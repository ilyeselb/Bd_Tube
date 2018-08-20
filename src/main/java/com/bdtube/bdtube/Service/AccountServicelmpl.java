package com.bdtube.bdtube.Service;

import com.bdtube.bdtube.Model.Account;
import com.bdtube.bdtube.Repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServicelmpl implements AccountService {
    AccountRepository ar;
    @Override
    public List<Account> getAll() {
        return (List<Account>) ar.findAll();
    }

    @Override
    public void addAccount(Account account) {
        ar.save(account);

    }

    @Override
    public void deleteAccount(int id) {
        ar.deleteById(id);

    }

    @Override
    public Optional<Account> getaccountByid(int id) {
        return ar.findById(id);
    }

    @Override
    public void updateAccount(Account account) {
ar.save(account);
    }
}
