package com.alpha07;

import com.alpha07.entity.Instructor;
import com.alpha07.entity.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteAppBi {
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
            int id = 3;

            // Retrieve the instructorDetail object
            InstructorDetails instructorDetails = session.get(InstructorDetails.class,id);

            // Delete the instructionDetail object
            if (instructorDetails != null){
                System.out.println(">> Deleting : " + instructorDetails);
                System.out.println(">> Associated instructor : " + instructorDetails.getInstructor() + " will also be deleted");
                session.remove(instructorDetails);
            } else {
                System.out.println(">> No such instructor exist!");
            }

            // Commit the transaction
            System.out.println(">> Committing transaction");
            transaction.commit();

        } finally {
            factory.close();
        }
    }
}
