package models;

import java.util.Objects;
import  Exception.*;
import Validation.*;


public class Customer {
    private static int id;
    private String name;
    private String email;

    static CustomerValidation  customerValidation=new CustomerValidation();
    public static Customer createCustomer(int id, String name, String email) throws CustomerValidationException {
        if (id <= 0) {
            throw new InvalidCustomerIdException("Invalid Id: " + id);
        }

        if (!customerValidation.isValidName(name)) {
            throw new InvalidCustomerNameException("Invalid Name: " + name);
        }

        if (!customerValidation.isValidEmail(email)) {
            throw new InvalidEmailException("Invalid Email: " + email);
        }

        return new Customer(id, name, email);
    }

    private Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static int  getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(name, customer.name) && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }



}


