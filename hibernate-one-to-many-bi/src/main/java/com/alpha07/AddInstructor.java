package com.alpha07;

import com.alpha07.entity.Course;
import com.alpha07.entity.Instructor;
import com.alpha07.entity.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddInstructor {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        System.out.println(">> Beginning transaction");
        Transaction transaction = session.beginTransaction();

        try {
            // Create Instructor object
            Instructor instructor = new Instructor("Ferdinand", "Barton", "russ.baxter@example.com");
            System.out.println(">> " + instructor);

            // Create InstructorDetails object
            InstructorDetails instructorDetails = new InstructorDetails("youtube.com/interdict", "Malcolm");
            System.out.println(">> " + instructorDetails);

            // Link InstructorDetails to Instructor object
            instructor.setInstructorDetails(instructorDetails);
            System.out.println("Instructor details : " + instructor.getInstructorDetails());

            // Save the Instructor object
            System.out.println(">> Saving the instructor object");
            session.persist(instructor);

            // Commit the transaction
            System.out.println(">> Committing transaction");
            transaction.commit();
            System.out.println("Saved : " + instructor);
            System.out.println("Saved : " + instructorDetails);

        } finally {
            session.close();
            factory.close();
        }
    }
}
