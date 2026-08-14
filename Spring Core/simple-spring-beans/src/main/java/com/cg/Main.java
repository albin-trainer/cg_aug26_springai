package com.cg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("Spring Container is ready");
        GreetingBean greetingBean= (GreetingBean)context.getBean("gbean");
        System.out.println(greetingBean.sayHello("Albin"));
        GreetingBean greetingBean2= (GreetingBean)context.getBean("gbean");

        System.out.println(greetingBean==greetingBean2); //checking the memory ref
        }
}