package com.alpha07.springaop;

import com.alpha07.springaop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Read java config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // Retrieve the bean from spring controller
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // Execute bean method
        accountDAO.addAccount();

        // Close the context
        context.close();
    }
}
