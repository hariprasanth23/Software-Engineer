package com.learn.aopdemo.dao;

import com.learn.aopdemo.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount() {
        System.out.println("class(AccountDAOImpl)-->addAccount()");
    }

    @Override
    public void addAccount(Account account) {
        System.out.println("class(AccountDAOImpl)-->addAccount(Account account)");
    }

    @Override
    public void addAccountWithCustomerDetails(Account account, String firstName, String lastName) {
        System.out.println("class(AccountDAOImpl)-->addAccountWithCustomerDetails(Account account, String firstName, String lastName)");
    }

    @Override
    public boolean accountActive() {
        System.out.println("class(AccountDAOImpl)-->accountActive()");
        return false;
    }

    @Override
    public List<Account> findAccounts() {
        System.out.println("class(AccountDAOImpl)-->findAccounts()");
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account("firstName1","lastName1",1,"email1"));
        accountList.add(new Account("firstName2","lastName2",2,"email2"));
        accountList.add(new Account("firstName3","lastName3",3,"email3"));
        accountList.add(new Account("firstName4","lastName4",4,"email4"));
        return accountList;
    }

    @Override
    public List<Account> findAccounts(String firstName) {
        System.out.println("class(AccountDAOImpl)-->indAccounts(String firstName)");
        return null;
    }
}
