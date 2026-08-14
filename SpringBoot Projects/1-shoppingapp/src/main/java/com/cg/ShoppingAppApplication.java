package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingAppApplication {

    public static void main(String[] args) {
        //Initialize  Sprint container (ApplicationContext)
        SpringApplication.run(ShoppingAppApplication.class, args);
    }
}
