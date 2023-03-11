package com.alpha07;

import com.alpha07.entity.Course;
import com.alpha07.entity.Instructor;
import com.alpha07.entity.InstructorDetails;
import com.alpha07.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateCourseReviews {
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
            int id = 2;
            Course course = session.get(Course.class, id);
            System.out.println(course);

            // Create course reviews
            Review review1 = new Review("Great course..amazing experience!");
            Review review2 = new Review("Disgusting!!");

            // Add reviews to course
            course.addReview(review1);
            course.addReview(review2);

            // Save reviews
            session.persist(review1);
            session.persist(review2);

            // Commit the transaction
            System.out.println(">> Committing the transaction");
            transaction.commit();
        }
    }
}
