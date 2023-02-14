package com.alpha07.springioc;

public class HappyFortuneService implements FortuneService {
    @Override
    public void getFortune() {
        System.out.println("Happy Fortune!");
    }
}
