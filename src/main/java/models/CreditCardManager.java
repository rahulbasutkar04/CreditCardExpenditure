package models;

import java.time.Month;

import models.CreditCard;
import models.Customer;
import Exception.*;
import models.Transaction;

public class CreditCardManager {
    private static CreditCard creditCard; // Assuming CreditCard is another class where card method is defined

    public CreditCardManager() {
        this.creditCard = new CreditCard(); // Assuming CreditCard has a default constructor
    }

    public Customer createCustomer(int customerId, String customerName, String customerEmail) throws CustomerValidationException, CustomerValidationException {
        // Create a customer using the provided data
        Customer customer = Customer.createCustomer(customerId, customerName, customerEmail);
        return customer;
    }

    public static boolean assignCard(Customer customer) {
        // Extract data from the customer object and pass it to the card method
        int id = customer.getId();
        String name = customer.getName();
        String email = customer.getEmail();
        return creditCard.card(id, name, email); // Assuming card method takes these parameters
    }

    public boolean MakeTransactions( String grocery, double amount, Month month) {
        return Transaction.perform(grocery,amount,month);
    }
}
