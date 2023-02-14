package com.alpha07.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        // Read the configuration file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        // Retrieve the beans from the configuration file
        CricketCoach myCricketCoach = context.getBean("cricketCoach", CricketCoach.class);
        Coach myFootballCoach = context.getBean("footballCoach", Coach.class);
        SwimCoach mySwimCoach = context.getBean("swimCoach", SwimCoach.class);

        // Use bean methods
        System.out.println("\n------------ Cricket Coach ------------");
        myCricketCoach.getDailyWorkout();
        myCricketCoach.getDailyFortune();

        System.out.println("\n------------ Swim Coach ------------");
        mySwimCoach.getDailyWorkout();
        mySwimCoach.getDailyFortune();
        System.out.println("Coach name : " + mySwimCoach.getName());
        System.out.println("Coach email : " + mySwimCoach.getEmail());

        System.out.println("\n------------ Football Coach ------------");
        myFootballCoach.getDailyWorkout();
        myFootballCoach.getDailyFortune();

        // Close the context
        context.close();
    }
}
