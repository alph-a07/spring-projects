package com.alpha07;

import com.alpha07.entity.Course;
import com.alpha07.entity.Instructor;
import com.alpha07.entity.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteCourse {
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
            int id = 3;

            // Retrieve the course and its instructor
            Course course = session.get(Course.class,id);
            Instructor instructor = course.getInstructor();

            System.out.println("Instructor before deleting the course : " + instructor);
            System.out.println(">> Instructor courses : " + instructor.getCourses());

            // Delete the course from instructors list and database
            System.out.println(">> Deleting course : " + course);
            session.remove(course);
            instructor.getCourses().remove(course);

            // Commit the transaction
            System.out.println(">> Committing transaction");
            transaction.commit();
            System.out.println("Instructor after deleting the course : " + instructor);
            System.out.println(">> Instructor courses : " + instructor.getCourses());

        } finally {
            // CLOSE SESSION BEFORE FACTORY
            session.close();
            factory.close();
        }
    }
}
