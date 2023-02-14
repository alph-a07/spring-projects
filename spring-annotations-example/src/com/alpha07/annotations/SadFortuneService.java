package com.alpha07.annotations;

import org.springframework.stereotype.Component;

@Component
public class SadFortuneService implements FortuneService {
    @Override
    public void getFortune() {
        System.out.println("Sad fortune!");
    }
}
