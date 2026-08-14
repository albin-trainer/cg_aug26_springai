package com.cg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
      //  ApplicationContext context = 
       // new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context =
         new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println("Spring Container is ready to use");
        AccountService accountService = (AccountService) context.getBean("accountService");
        System.out.println(accountService.creditService(1000.0f));
    }
}