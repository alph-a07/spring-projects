package com.alpha07.springioc;

public class CricketCoach implements Coach {
    private FortuneService fortuneService; // from setter method
    private String teamName; // value from setter method
    private String captainName; // value from properties file

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setFortuneService(FortuneService fortuneService) {
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
