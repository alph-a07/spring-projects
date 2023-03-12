package com.alpha07.controller;

import com.alpha07.dao.CustomerDAO;
import com.alpha07.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // The implementation will be autowired by Spring thanks to @Repository
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model model){

        // Retrieve customers list
        List<Customer> customers = customerDAO.getCustomers();

        // Add customers list to model as attribute
        // to use it in jsp file
        model.addAttribute("customers",customers);

        return "list-customers";
    }
}
