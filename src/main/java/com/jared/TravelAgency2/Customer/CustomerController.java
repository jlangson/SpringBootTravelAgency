/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jared.TravelAgency2.Customer;

import java.util.List;
import java.util.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author jared
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping(value="/")
    public String index(Customer customer) {
	//Where we want to go when our application is started
        return "customer/index";
    }
    
    private Customer customer;
    @PostMapping(value = "/")
    public String addNewCustomer(Customer customer, Model model){
        customerRepository.save(new Customer(customer.getFirstName(), customer.getLastName(), customer.getDestination(), customer.getSignedUp(), customer.getBudget(), customer.getEmail()));
        model.addAttribute("firstName",customer.getFirstName());
        model.addAttribute("lastName",customer.getLastName());
        model.addAttribute("destination",customer.getDestination());
        model.addAttribute("budget",customer.getBudget());
        model.addAttribute("email",customer.getEmail());
  
    return "customer/result";
    }
   
    @GetMapping(value ="/rich")
    public String showRich(Customer customer, Model model){
        Iterable <Customer> allCustomers = customerRepository.findAll();
        Stack <Customer> richCustomers = new Stack <Customer>();
        for(Customer varCustomer : allCustomers){
           if(varCustomer.getBudget() >=2000){
               richCustomers.push(varCustomer);
           }
        }
        
        model.addAttribute("richCustomers", richCustomers); //i think this says take the allCustomer java variable and put it in the html file as allCustomers
        return "customer/rich";
                
    }
    
}
