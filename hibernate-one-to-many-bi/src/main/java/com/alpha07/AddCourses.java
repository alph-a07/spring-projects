package com.alpha07;

import com.alpha07.entity.Course;
import com.alpha07.entity.Instructor;
import com.alpha07.entity.InstructorDetails;
import com.alpha07.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddCourses {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Readable.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        System.out.println(">> Beginning transaction");

        try (factory; session) {
            int id = 2;

            // Retrieve the instructor object
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println(instructor.getCourses());

            // Create courses for instructor
            Course networksCourse = new Course("Computer Communication Networks");
            Course osCourse = new Course("Operating System");
            Course dbmsCourse = new Course("Database Management System");

            // Link courses to instructor
            instructor.addCourse(networksCourse);
            instructor.addCourse(osCourse);
            instructor.addCourse(dbmsCourse);

            // Instructor is already saved to database
            // Add courses to database
            session.persist(networksCourse);
            session.persist(osCourse);
            session.persist(dbmsCourse);

            // Commit the transaction
            System.out.println(">> Committing transaction");
            transaction.commit();

        }
    }
}
