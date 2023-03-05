package com.alpha07.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestRead {
    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Create Student object
            Student student = new Student("Jake", "Paul", "itsjake02@gmail.com");

            // Start the transaction
            System.out.println(">> Beginning create transaction");
            session.beginTransaction();

            // Save the object
            // session.save(student); -- DEPRECATED
            session.persist(student);

            // Commit the transaction
            System.out.println(">> Committing create transaction");
            session.getTransaction().commit();
            System.out.println(">> Saved object : " + student);

            // Get the student ID
            int studentID = student.getId();

            // Start the transaction
            session = factory.getCurrentSession();
            System.out.println(">> Beginning read transaction");
            session.beginTransaction();

            // Read the object
            System.out.println(">> Reading object with ID : " + studentID);
            Student myStudent = session.get(Student.class, studentID);

            // Commit the transaction
            System.out.println(">> Committing read transaction");
            session.getTransaction().commit();
            System.out.println(">> Retrieved student : " + myStudent);
        }
        finally {
            session.close();
        }
    }
}
