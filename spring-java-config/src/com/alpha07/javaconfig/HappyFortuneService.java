package com.alpha07.javaconfig;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
    @Override
    public void getFortune() {
        System.out.println("Happy fortune!");
    }
}
