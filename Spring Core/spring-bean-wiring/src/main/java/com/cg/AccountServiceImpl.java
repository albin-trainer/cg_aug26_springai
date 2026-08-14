package com.cg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AccountServiceImpl implements AccountService {
   @Autowired
   @Qualifier("accountRepositoryImpl")
   private AccountRepository accountRepository;
   // @Autowired
   public AccountServiceImpl() {
        System.out.println("AccountServiceImpl object created");
        //this.accountRepository = accountRepository;
    }
   // @Autowired 
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        System.out.println("repository injected");
    }
    public String creditService(float amt) {
        return accountRepository.credit(amt);
    }

}
