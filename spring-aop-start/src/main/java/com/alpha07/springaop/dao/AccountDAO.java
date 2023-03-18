package com.alpha07.springaop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(){
        System.out.println(">> INFO : Adding an account");
    }
}
