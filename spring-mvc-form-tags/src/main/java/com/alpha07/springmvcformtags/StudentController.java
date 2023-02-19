package com.alpha07.springmvcformtags;

import com.alpha07.springmvcformtags.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    // 1 - Controller method to show student form
    @RequestMapping("/")
    public String showForm(Model model) {

        // Create a new student object
        Student student = new Student();
        // student.setFirstName("Default First Name");

        // Add the student object to the model
        model.addAttribute("student", student);

        // A fresh student object is set as model attribute before displaying form
        return "student-form";
    }

    // 3 - Controller method to process the form response
    @RequestMapping("/submit")
    public String processForm(@ModelAttribute("student") Student student) {
        // The student object is automatically bound with form responses from due to @ModelAttribute
        System.out.println("Student name: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Student email: " + student.getEmail());
        System.out.println("Student country: " + student.getCountry());
        System.out.println("Favourite programming language: " + student.getFavProgrammingLanguage());

        return "confirmation";
    }
}