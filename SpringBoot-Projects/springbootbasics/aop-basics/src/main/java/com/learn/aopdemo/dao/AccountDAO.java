package com.learn.aopdemo.dao;

import com.learn.aopdemo.entity.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount();
    void addAccount(Account account);
    void addAccountWithCustomerDetails(Account account,String firstName,String lastName);
    boolean accountActive();
    List<Account> findAccounts();
    List<Account> findAccounts(String firstName);
}
