package com.alpha07.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        // Read the configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the beans from the configuration file
        CricketCoach myCricketCoach = context.getBean("cricketCoach", CricketCoach.class);
        Coach myFootballCoach = context.getBean("footballCoach", Coach.class);

        // Use bean methods
        myCricketCoach.getDailyWorkout();
        myCricketCoach.getDailyFortune();
        System.out.println("Team name : " + myCricketCoach.getTeamName());
        System.out.println("Captain name : " + myCricketCoach.getCaptainName());

        myFootballCoach.getDailyWorkout();
        myFootballCoach.getDailyFortune();

        // Close the context
        context.close();
    }
}
