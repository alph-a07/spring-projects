package com.alpha07.fortunes;

import com.alpha07.interfaces.FortuneService;

public class HappyFortuneService implements FortuneService {
    @Override
    public void getFortune() {
        System.out.println("Happy Fortune!");
    }
}
