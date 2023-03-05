package com.alpha07.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TestQuery {
    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Create a query using HQL
            List<Student> queryResult = session.createQuery("FROM Student", Student.class).getResultList();

            // Display query results
            System.out.println("\nAll students :");
            display(queryResult);

            // Create query of students whose lastName = Doe
            queryResult = session.createQuery("FROM Student s WHERE s.lastName='Doe'", Student.class).getResultList();

            // Display query results
            System.out.println("\nStudents whose last name is 'Doe' : ");
            display(queryResult);

            // Create query of students whose lastName = Doe OR firstName = Jeel
            queryResult = session.createQuery("FROM Student s WHERE s.lastName='Doe' OR s.firstName='Jeel'", Student.class).getResultList();

            // Display query results
            System.out.println("\nStudents whole last name is 'Doe' or first name is 'Jeel' : ");
            display(queryResult);

            // Create query of students whole email ends like s@gmail.com
            queryResult = session.createQuery("FROM Student s WHERE s.email LIKE '%s@gmail.com'",Student.class).getResultList();

            // Display query results
            System.out.println("\nStudents whose email ends with s@gmail.com : ");
            display(queryResult);

            // Commit the transaction
            transaction.commit();
        } finally {
            factory.close();
        }
    }

    private static void display(List<Student> queryResult) {
        for (Student query : queryResult) {
            System.out.println(query);
        }
    }
}
