package models;

import Exception.CustomerValidationException;

import java.time.Month;

public class CreditCardManager {
    private int customerId; // Correct variable name

    private static CreditCard creditCard; // Assuming CreditCard is another class where card method is defined

    public CreditCardManager() {
        this.creditCard = new CreditCard(); // Assuming CreditCard has a default constructor
    }

    public Customer createCustomer(int customerId, String customerName, String customerEmail) throws CustomerValidationException {
        // Create a customer using the provided data
        this.customerId = customerId; // Assign the customerId to the customerId variable
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

    public boolean MakeTransactions(Category category, double amount, Month month) {
        Transaction transaction = new Transaction(this.customerId); // Assuming you have customerId available
        return transaction.perform(category, amount, month);
    }
}