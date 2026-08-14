package com.example;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
         return "Hello !!!!";
    }
     @GetMapping("/admin")
    public String admin(){
         return "ADMIN PAGE !!!!";
    }

     @GetMapping("/user")
    public String user(){
         return "USER PAGE !!!!";
    }

}
