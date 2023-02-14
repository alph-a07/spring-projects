package com.alpha07.javaconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:swim-coach.properties")
@ComponentScan("com.alpha07.javaconfig")
public class JavaConfiguration {

    @Value("${swim.email}")
    private String swimCoachEmail;

    // HappyFortuneService bean
    @Bean
    public FortuneService happyFortuneService() {
        return new SadFortuneService();
    }

    // SwimCoach bean
    @Bean
    public SwimCoach swimCoach() {
        // Constructor injection
        SwimCoach swimCoach = new SwimCoach(happyFortuneService());
        swimCoach.setEmail(swimCoachEmail);
        return swimCoach;
    }
}
