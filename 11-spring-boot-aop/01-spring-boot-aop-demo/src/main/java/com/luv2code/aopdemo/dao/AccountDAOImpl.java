package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;


@Repository // help for component scanning
public class AccountDAOImpl implements AccountDAO
{
    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": DOING DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
