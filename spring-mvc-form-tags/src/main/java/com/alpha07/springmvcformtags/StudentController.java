package com.alpha07.springmvcformtags;

import com.alpha07.springmvcformtags.models.Student;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

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
    public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {

        System.out.println("\n >> " + bindingResult + "\n");

        // If the bindingResult has errors, show the form again
        if (bindingResult.hasErrors()) {
            return "student-form";
        }
        // Else, display the confirmation message
        else {
            // The student object is automatically bound with form responses from due to @ModelAttribute
            System.out.println("Student name: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Student age: " + student.getAge());
            System.out.println("Student email: " + student.getEmail());
            System.out.println("Student country: " + student.getCountry());
            System.out.println("Student pincode: " + student.getPincode());
            System.out.println("Favourite programming language: " + student.getFavProgrammingLanguage());
            System.out.print("Spoken languages: ");
            for (String language : student.getLanguages()) {
                System.out.print(language + " ");
            }
            return "confirmation";
        }
    }
}