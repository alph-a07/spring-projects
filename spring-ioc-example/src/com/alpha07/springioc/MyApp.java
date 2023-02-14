package com.alpha07.springioc;

import com.alpha07.coaches.CricketCoach;
import com.alpha07.interfaces.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        // Load the Spring Configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get bean from Spring Container
        Coach myCoach = context.getBean("myCoach", Coach.class);
        CricketCoach myCricketCoach = context.getBean("myCricketCoach", CricketCoach.class);

        // Use bean methods
        myCoach.getDailyWorkout();
        myCoach.getDailyFortune();
        myCricketCoach.getDailyWorkout();
        myCricketCoach.getDailyFortune();
        System.out.println("Team name: " + myCricketCoach.getTeamName());
        System.out.println("Captain name: " + myCricketCoach.getCaptainName());

        // Close Spring Context
        context.close();
    }
}
