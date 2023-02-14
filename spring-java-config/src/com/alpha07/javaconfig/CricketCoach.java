package com.alpha07.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    private final FortuneService fortuneService;

    @Value("${cricket.teamName}")
    private String teamName;

    @Value("${cricket.captainName}")
    private String captainName;

    public String getTeamName() {
        return teamName;
    }

    public String getCaptainName() {
        return captainName;
    }

    // Constructor injection
    @Autowired
    public CricketCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public void getDailyWorkout() {
        System.out.println("Cricket workout!");
    }

    @Override
    public void getDailyFortune() {
        fortuneService.getFortune();
    }
}
