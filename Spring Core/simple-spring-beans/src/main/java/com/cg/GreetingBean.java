package com.cg;

public class GreetingBean {
    private String message;
    GreetingBean(){
        System.out.println("GreetingBean object is created");
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    public String sayHello(String name){
        return name + " " + message;
    }
}
