package com.alpha07.springhtmlform;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
    public String addToModel(HttpServletRequest httpServletRequest, Model model) {
        // Retrieve form data from request
        String name = httpServletRequest.getParameter("name").toUpperCase(); // modified
        String email = httpServletRequest.getParameter("email");

        // Add form data to model
        model.addAttribute("myName", name);
        model.addAttribute("myEmail", email);

        return "successV2";
    }
}
