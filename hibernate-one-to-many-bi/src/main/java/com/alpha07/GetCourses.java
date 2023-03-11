package com.alpha07;

import com.alpha07.entity.Course;
import com.alpha07.entity.Instructor;
import com.alpha07.entity.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

        try (factory; session) {
            int id = 4;

            // Create HQL query to eager load instructor and courses
            Query<Instructor> query = session.createQuery("SELECT i FROM Instructor i " +
                    "JOIN FETCH i.courses " +
                    "WHERE i.id=:queryID", Instructor.class);

            // Set instructor ID as query parameter
            query.setParameter("queryID", id);

            // Retrieve the instructor
            // Courses will also be loaded into memory
            Instructor instructor = query.getSingleResult();

            System.out.println(instructor);

            // Commit the transaction
            System.out.println(">> Committing transaction");
            transaction.commit();

            // Close the session
            session.close();
            System.out.println(">> Session closed!");

            // Try to get courses after session is closed -- SUCCESS
            if (instructor != null) {
                System.out.println(instructor.getCourses());
            }
        }
    }
}
