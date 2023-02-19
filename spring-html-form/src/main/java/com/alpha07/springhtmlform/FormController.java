package com.alpha07.springhtmlform;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

    @Controller
    @RequestMapping("/home")
    public class FormController {

        // Controller method for displaying HTML form
        // 1 - Display from when request to root is sent
        @RequestMapping("/")
        public String showForm() {
            return "form";
        }

        // Controller method for processing HTML form responses
        // 2 - Display form responses when form is submitted (GET)
        @RequestMapping("/process")
        public String processForm() {
            return "success";
        }

        // Controller method for adding responses to Spring model
        @RequestMapping("/processV2")
        public String addToModel(HttpServletRequest request, Model model) {
            // Retrieve form data from request
            String name = request.getParameter("name").toUpperCase(); // modified
            String email = request.getParameter("email");

            // Add form data to model
            model.addAttribute("myName", name);
            model.addAttribute("myEmail", email);

            return "successV2";
        }

        // Controller method for adding responses to Spring model using annotation
        @RequestMapping("/processV3")
        public String addToModelUsingAnnotations(@RequestParam("name") String name, @RequestParam("email") String email, Model model) {

            // Add form data to model
            model.addAttribute("myName", name);
            model.addAttribute("myEmail", email);

            return "successV2";
        }
    }
