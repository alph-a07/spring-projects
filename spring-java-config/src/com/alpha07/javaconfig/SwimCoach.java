package com.alpha07.javaconfig;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{
    private FortuneService happyFortuneService;

    @Value("${swim.name}")
    private String name;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public SwimCoach(FortuneService happyFortuneService) {
        this.happyFortuneService = happyFortuneService;
    }

    @Override
    public void getDailyWorkout() {
        System.out.println("Swim workout!");
    }

    @Override
    public void getDailyFortune() {
        happyFortuneService.getFortune();
    }
}
