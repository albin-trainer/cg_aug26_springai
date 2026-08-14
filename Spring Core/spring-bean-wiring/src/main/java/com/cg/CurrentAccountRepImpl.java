package com.cg;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CurrentAccountRepImpl implements AccountRepository {

    public CurrentAccountRepImpl() {
        System.out.println("CurrentAccountRepImpl object created");
    }

    @Override
    public String credit(float amt) {
        return "Current Account credited: " + amt;
    }
}
