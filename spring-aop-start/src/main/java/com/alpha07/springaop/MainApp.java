package com.alpha07.springaop;

import com.alpha07.springaop.dao.AccountDAO;
import com.alpha07.springaop.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // Read java config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // Retrieve the bean from spring controller
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // Execute bean method
        List<Account> accountList = null;
        Account account = new Account("omnesque", "atqui");
        accountDAO.addAccount(account);

        try {
            accountList = accountDAO.findAccounts(true); // purposefully throw an exception to demonstrate @AfterThrowing
        } catch (Exception e){
            System.out.println("Execution exception : " + e);
        }

        System.out.println("Result from execution : " + accountList);

        // Close the context
        context.close();
    }
}
