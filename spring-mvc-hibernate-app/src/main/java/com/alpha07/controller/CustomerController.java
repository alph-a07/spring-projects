package com.alpha07.controller;

import com.alpha07.entity.Customer;
import com.alpha07.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // The implementation will be autowired by Spring thanks to @Service
    @Autowired
    private CustomerService customerService;

    // @RequestMapping(value = "/list", method = RequestMethod.GET)
    @GetMapping("/list")
    public String listCustomers(Model model) {

        // Retrieve customers list
        List<Customer> customers = customerService.getCustomers();

        // Add customers list to model as attribute
        // to use it in jsp file
        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/showAddForm")
    public String showAddForm(Model model) {
        // Add customer object to model attribute for data binding
        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "add-customer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        // Save customer
        customerService.saveCustomer(customer);

        // Redirect to customers list
        return "redirect:/customer/list";
    }

    @GetMapping("/showUpdateForm")
    public String shoeCustomerForm(Model model, @RequestParam("customerId") int customerID){
        // Get customer from the id
        Customer customer = customerService.getCustomer(customerID);

        // Set customer as model attribute to fill the form with existing data
        model.addAttribute("customer",customer);

        return "add-customer";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int customerID){

        // Delete the customer with id = customerID
        customerService.deleteCustomer(customerID);

        return "redirect:/customer/list";
    }
}
