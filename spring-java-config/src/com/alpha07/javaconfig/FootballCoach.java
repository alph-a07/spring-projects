package com.alpha07.javaconfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.*;

@Component
public class FootballCoach implements Coach {

    private final FortuneService fortuneService;

    public FootballCoach(@Qualifier("sadFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public void getDailyWorkout() {
        System.out.println("Football workout!");
    }

    @Override
    public void getDailyFortune() {
        fortuneService.getFortune();
    }

    @PostConstruct
    public void initMethod() {
        System.out.println(">> Bean Initialized");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println(">> Bean Destroyed");
    }
}
