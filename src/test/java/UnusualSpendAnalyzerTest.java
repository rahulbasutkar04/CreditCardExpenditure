import models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Exception.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnusualSpendAnalyzerTest {

    @BeforeEach
    void setUp() {

        UnusualSpendAnalyzer.clearCurrent();
        UnusualSpendAnalyzer.clearPrevious();
    }

    @Test
    void shouldAbleToGetTheUnusualSpends() throws CustomerValidationException {
        Customer customer = Customer.createCustomer(1, "xyz", "rahulbasutkar@gmail.com");
        CreditCardManager.assignCard(customer);

            Transaction transaction = new Transaction(customer.getId());
            transaction.perform(Category.BOOKS, 1200, Month.MARCH);
            transaction.perform(Category.GROCERY, 1000, Month.MARCH);
            transaction.perform(Category.ELECTRONICS, 800, Month.MARCH);

            transaction.perform(Category.BOOKS, 600, Month.FEBRUARY);
            transaction.perform(Category.GROCERY, 900, Month.FEBRUARY);
            transaction.perform(Category.ELECTRONICS, 500, Month.FEBRUARY);

        UnusualSpendAnalyzer unusualSpendAnalyzer=new UnusualSpendAnalyzer();
       assertTrue(unusualSpendAnalyzer.calculate(Transaction.getTransactionsByCustomerId()));

    }

    @Test
    void shouldAbleToCalculateTotalAmountOfCurrentMonth() throws CustomerValidationException {
        // Create a customer
        Customer customer = Customer.createCustomer(1, "xyz", "rahulbasutkar@gmail.com");
        CreditCardManager.assignCard(customer);

        // Perform transactions for February and March
        Transaction transaction = new Transaction(customer.getId());
        transaction.perform(Category.BOOKS, 1200, Month.MARCH);
        transaction.perform(Category.GROCERY, 1000, Month.MARCH);
        transaction.perform(Category.ELECTRONICS, 800, Month.MARCH);

        transaction.perform(Category.BOOKS, 600, Month.FEBRUARY);
        transaction.perform(Category.GROCERY, 900, Month.FEBRUARY);
        transaction.perform(Category.ELECTRONICS, 500, Month.FEBRUARY);

        // Create an UnusualSpendAnalyzer instance
        UnusualSpendAnalyzer unusualSpendAnalyzer = new UnusualSpendAnalyzer();

        // Calculate total spend for each month
        unusualSpendAnalyzer.calculate(Transaction.getTransactionsByCustomerId());
       int actual= unusualSpendAnalyzer.currentMonthTotal(unusualSpendAnalyzer.getCurrentMonthTransactions());

       assertEquals(3000,actual);

    }




    @Test
    void shouldAbleToCalculateTotalAmountOfPrevoiusMonth() throws CustomerValidationException {
        // Create a customer
        Customer customer = Customer.createCustomer(1, "xyz", "rahulbasutkar@gmail.com");
        CreditCardManager.assignCard(customer);

        // Perform transactions for February and March
        Transaction transaction = new Transaction(customer.getId());
        transaction.perform(Category.BOOKS, 1200, Month.MARCH);
        transaction.perform(Category.GROCERY, 1000, Month.MARCH);
        transaction.perform(Category.ELECTRONICS, 800, Month.MARCH);

        transaction.perform(Category.BOOKS, 600, Month.FEBRUARY);
        transaction.perform(Category.GROCERY, 900, Month.FEBRUARY);
        transaction.perform(Category.ELECTRONICS, 500, Month.FEBRUARY);

        // Create an UnusualSpendAnalyzer instance
        UnusualSpendAnalyzer unusualSpendAnalyzer = new UnusualSpendAnalyzer();

        // Calculate total spend for each month
        unusualSpendAnalyzer.calculate(Transaction.getTransactionsByCustomerId());
        int actual= unusualSpendAnalyzer.currentMonthTotal(unusualSpendAnalyzer.getPreviousMonthTransactions());

        assertEquals(2000,actual);

    }

}
