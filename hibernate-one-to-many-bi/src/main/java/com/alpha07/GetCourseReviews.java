package com.alpha07;

import com.alpha07.entity.Course;
import com.alpha07.entity.Instructor;
import com.alpha07.entity.InstructorDetails;
import com.alpha07.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetCourseReviews {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        System.out.println(">> Beginning transaction");

        try (factory; session) {
            // Retrieve a course
            int id = 1;
            Course course = session.get(Course.class, id);
            System.out.println(course);

            // Get course reviews
            System.out.println(course.getReviews());

            // Commit the transaction
            System.out.println(">> Committing the transaction");
            transaction.commit();
        }
    }
}