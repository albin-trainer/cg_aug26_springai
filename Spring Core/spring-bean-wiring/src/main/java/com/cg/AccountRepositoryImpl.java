package com.cg;

import org.springframework.stereotype.Component;


@Component //replaces <bean> in xml file and @Bean in java config file
public class AccountRepositoryImpl implements AccountRepository {
public AccountRepositoryImpl() {
        System.out.println("AccountRepositoryImpl object created");
    }
    @Override
    public String credit(float amt) {
        return " Savings Account credited: " + amt;
    }

}
