package com.alpha07;

import com.alpha07.entity.Instructor;
import com.alpha07.entity.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteAppUni {
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
            int id = 1;

            // Retrieve the object from database
            Instructor instructor = session.get(Instructor.class,id);

            // Delete the object if not null
            if (instructor!=null){
                // session.delete(instructor); -- DEPRECATED
                System.out.println(">> Removing instructor : " + instructor);
                System.out.println(">> Instructor details : " + instructor.getInstructorDetails() + " will also be deleted");
                session.remove(instructor);
            } else
                System.out.println(">> No such instructor exist!");

            // Commit the transaction
            System.out.println(">> Committing transaction");
            transaction.commit();

        } finally {
            factory.close();
        }
    }
}
