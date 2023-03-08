package com.alpha07;

import com.alpha07.entity.Instructor;
import com.alpha07.entity.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddInstructorDetails {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        System.out.println(">> Beginning transaction");
        Transaction transaction = session.beginTransaction();

        try {
            // Create InstructorDetails object
            InstructorDetails instructorDetails = new InstructorDetails("youtube.com/tristate", "Vernon Roche");
            System.out.println(">> " + instructorDetails);

            // Create Instructor object
            Instructor instructor = new Instructor("Florencio", "Hill", "dirk.hood@example.com");
            System.out.println(">> " + instructor);

            // Link Instructor to InstructorDetail object
            instructorDetails.setInstructor(instructor);

            // Save the Instructor object
            System.out.println(">> Saving the instructorDetails object");
            session.persist(instructorDetails);

            // Commit the transaction
            System.out.println(">> Committing transaction");
            transaction.commit();
            System.out.println("Saved : " + instructorDetails);
            System.out.println("Saved : " + instructor);

        } finally {
            session.close();
            factory.close();
        }
    }
}
