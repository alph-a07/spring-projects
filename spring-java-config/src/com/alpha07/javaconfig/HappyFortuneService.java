package com.alpha07.annotations;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
    @Override
    public void getFortune() {
        System.out.println("Happy fortune!");
    }
}
