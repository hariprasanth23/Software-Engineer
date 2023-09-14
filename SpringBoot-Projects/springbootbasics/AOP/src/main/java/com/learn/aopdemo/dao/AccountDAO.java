package com.learn.aopdemo.dao;

import com.learn.aopdemo.entity.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount();
    void addAccount(Account account);
    void addAccount(Account account,boolean vipFlag);
    boolean addSillyMember();
    boolean doWork();
    List<Account> findAccounts();
    List<Account> findAccounts(boolean tripWire);
    String getName();
    void setName(String name);
    String getServiceCode() ;
    void setServiceCode(String serviceCode);

}
