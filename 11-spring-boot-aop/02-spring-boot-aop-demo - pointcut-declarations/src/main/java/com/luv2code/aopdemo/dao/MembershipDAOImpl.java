package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;


@Repository // help for component scanning
public class MembershipDAOImpl implements MembershipDAO
{
    @Override
    public boolean addSillyMember() {

        System.out.println(getClass() + ": DOING DB WORK: ADDING A MEMBERSHIP ACCOUNT");

        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": i'm going to sleep now...");
    }
}
