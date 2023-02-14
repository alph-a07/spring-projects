package com.alpha07.coaches;

import com.alpha07.interfaces.Coach;
import com.alpha07.interfaces.FortuneService;

public class RaceCoach implements Coach {
    FortuneService happyFortuneService; // from constructor

    public RaceCoach(FortuneService happyFortuneService) {
        this.happyFortuneService = happyFortuneService;
    }

    @Override
    public void getDailyWorkout() {
        System.out.println("Race workout!");
    }

    @Override
    public void getDailyFortune() {
        happyFortuneService.getFortune();
    }
}
