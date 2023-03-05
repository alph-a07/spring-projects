package com.alpha07.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestCreate {
    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Create Student object
            Student student1 = new Student("Jeel", "Patel", "itsjeel02@gmail.com");
            Student student2 = new Student("John", "Doe", "johndoe@gmail.com");
            Student student3 = new Student("Jane", "Smith", "janesmith@gmail.com");
            Student student4 = new Student("Bob", "Johnson", "bobjohnson@gmail.com");
            Student student5 = new Student("Alice", "Williams", "alicewilliams@gmail.com");
            Student student6 = new Student("David", "Lee", "davidlee@gmail.com");
            Student student7 = new Student("Sarah", "Wilson", "sarahwilson@gmail.com");
            Student student8 = new Student("Tom", "Jones", "tomjones@gmail.com");
            Student student9 = new Student("Emily", "Davis", "emilydavis@gmail.com");
            Student student10 = new Student("Michael", "Brown", "michaelbrown@gmail.com");

            // Start the transaction
            System.out.println(">> Beginning transaction");
            Transaction transaction = session.beginTransaction();

            // Save the object
            // session.save(student); -- DEPRECATED
            session.persist(student1);
            session.persist(student2);
            session.persist(student3);
            session.persist(student4);
            session.persist(student5);
            session.persist(student6);
            session.persist(student7);
            session.persist(student8);
            session.persist(student9);
            session.persist(student10);

            // Commit the transaction
            System.out.println(">> Committing transaction");
            transaction.commit();
        } finally {
            factory.close();
        }
    }
}
