package com.learn.aopdemo.dao;

import com.learn.aopdemo.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{
    private String name;
    private String serviceCode;

    @Override
    public void addAccount() { System.out.println("class(AccountDAOImpl)-->addAccount()"); }

    @Override
    public void addAccount(Account account) {
        System.out.println("class(AccountDAOImpl)-->addAccount(Account account)");
    }

    @Override
    public void addAccount(Account account,boolean vipFlag) {
        System.out.println("class(AccountDAOImpl)-->addAccount(Account account,boolean vipFlag)");
    }

    @Override
    public boolean addSillyMember() {
        System.out.println("class(AccountDAOImpl)-->addSillyMember()");
        return true;
    }

    public boolean doWork(){
        System.out.println("class(AccountDAOImpl)-->doWork()");
        return false;
    }

    @Override
    public List<Account> findAccounts() {
        System.out.println("class(AccountDAOImpl)-->findAccounts()");
        List<Account> myAccounts = new ArrayList<>();
        myAccounts.add(new Account("Account1","Silver"));
        myAccounts.add(new Account("Account2","Platinum"));
        myAccounts.add(new Account("Account3","Gold"));
        return myAccounts;
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        System.out.println("class(AccountDAOImpl)-->findAccounts(boolean tripWire)");
        if(tripWire){
            throw new RuntimeException(" Better luck next Time ");
        }
        List<Account> myAccounts = new ArrayList<>();
        myAccounts.add(new Account("Account1","Silver"));
        myAccounts.add(new Account("Account2","Platinum"));
        myAccounts.add(new Account("Account3","Gold"));
        return myAccounts;
    }

    public String getName() {
        System.out.println("class(AccountDAOImpl)-->getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println("class(AccountDAOImpl)-->setName(String name)");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("class(AccountDAOImpl)-->getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("class(AccountDAOImpl)--setServiceCode(String serviceCode)");
        this.serviceCode = serviceCode;
    }
}
