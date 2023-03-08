package com.alpha07;

import com.alpha07.entity.Course;
import com.alpha07.entity.Instructor;
import com.alpha07.entity.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetCourses {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        System.out.println(">> Beginning transaction");

        try {
            int id = 2;

            // Retrieve the instructor object
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println(instructor);

            if (instructor != null) {
                // Retrieve instructor courses
                System.out.println("Instructor courses : " + instructor.getCourses());
            } else
                System.out.println(">> No such instructor!");

            // Commit the transaction
            System.out.println(">> Committing transaction");
            transaction.commit();

        } finally {
            // CLOSE SESSION BEFORE FACTORY
            session.close();
            factory.close();
        }
    }
}
