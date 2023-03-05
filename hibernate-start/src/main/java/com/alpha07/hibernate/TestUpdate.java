package com.alpha07.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestUpdate {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Retrieve the student you want to update
            Student student = session.get(Student.class, 2);

            // Modify the information
            student.setEmail("itsjeel01@gmail.com");

            // Query to update mails of students whose first names are 'Jake'
            session.createQuery("UPDATE Student s SET email='jakepaul@gmail.com' WHERE s.firstName='Jake'").executeUpdate(); // -- DEPRECATED

            // Commit the transaction
            transaction.commit();
        } finally {
            factory.close();
        }
    }
}
