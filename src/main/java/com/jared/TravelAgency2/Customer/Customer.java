/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jared.TravelAgency2.Customer;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author jared
 */

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String destination;
    @Column
    @CreationTimestamp
    private Date signedUp;
    private double budget;
    private String email;

    public Customer(String firstName, String lastName, String destination, Date signedUp, double budget, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.destination = destination;
        this.signedUp = signedUp;
        this.budget = budget;
        this.email = email;
    }



   

    public Customer() {
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public Date getSignedUp() {
        return signedUp;
    }
    

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", destination=" + destination + ", signedUp=" + signedUp + ", budget=" + budget + ", email=" + email + '}';
    }
    
    
}
