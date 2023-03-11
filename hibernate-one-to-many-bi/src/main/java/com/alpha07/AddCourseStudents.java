package com.alpha07;

import com.alpha07.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddCourseStudents {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        System.out.println(">> Beginning transaction");

        try (factory; session) {

            // Create course
            Course dmsCourse = new Course("Discrete mathematics");
            System.out.println(">> Course created : " + dmsCourse);

            // Create instructor for the course
            Instructor instructor = new Instructor("Timmy", "Kuhic", "robbie.george@example.com");
            InstructorDetails instructorDetails = new InstructorDetails("youtube.com/timmykuhic", "Arron");
            instructor.setInstructorDetails(instructorDetails);

            // Set course instructor
            dmsCourse.setInstructor(instructor);

            // Retrieve students for the course
            Student student1 = session.get(Student.class,10);
            Student student2 = session.get(Student.class,5);

            // Add students to the course
            System.out.println(">> Adding students to course");
            dmsCourse.addStudent(student1);
            dmsCourse.addStudent(student2);

            // Save the course
            System.out.println(">> Saving the course");
            session.persist(dmsCourse);

            // Commit the transaction
            System.out.println(">> Committing transaction");
            transaction.commit();
        }
    }
}
