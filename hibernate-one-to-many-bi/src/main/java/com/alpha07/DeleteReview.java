package com.alpha07;

import com.alpha07.entity.Course;
import com.alpha07.entity.Instructor;
import com.alpha07.entity.InstructorDetails;
import com.alpha07.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteReview {
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
            // Retrieve a review
            int id = 2;
            Review review = session.get(Review.class, id);
            System.out.println(review);

            // Delete the review
            System.out.println(">> Removing review : " + review.getComment());
            session.remove(review);

            // Commit the transaction
            System.out.println(">> Committing the transaction");
            transaction.commit();
        }
    }
}
