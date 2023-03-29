package com.alpha07.springaop.dao;

import com.alpha07.springaop.entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    public void addAccount(Account account) {
        System.out.println("Adding account : " + account);
    }

    public List<Account> findAccounts(Boolean exceptionFlag) {

        if (exceptionFlag) throw new RuntimeException("Stimulation exception!");

        List<Account> accounts = new ArrayList<>();

        Account account1 = new Account("Jeel","Platinum");
        Account account2 = new Account("Maitry","Diamond");

        accounts.add(account1);
        accounts.add(account2);

        return accounts;
    }
}
