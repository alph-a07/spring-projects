package com.alpha07.coaches;

import com.alpha07.interfaces.Coach;
import com.alpha07.interfaces.FortuneService;

public class BasketballCoach implements Coach {
    FortuneService happyFortuneService; // from constructor

    //
    public BasketballCoach(FortuneService happyFortuneService) {
        this.happyFortuneService = happyFortuneService;
    }

    @Override
    public void getDailyWorkout() {
        System.out.println("Basketball workout!");
    }

    @Override
    public void getDailyFortune() {
        happyFortuneService.getFortune();
    }

}
