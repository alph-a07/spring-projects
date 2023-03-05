package com.alpha07.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestDelete {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try{
            // Retrieve student
            Student student = session.get(Student.class,1);

            // Delete the retrieved object
            session.delete(student); // -- DEPRECATED

            // Delete id=2 student using HQL query
            session.createQuery("DELETE Student WHERE id=2").executeUpdate(); // -- DEPRECATED

            // Commit the transaction
            transaction.commit();
        } finally {
            factory.close();
        }
    }
}
