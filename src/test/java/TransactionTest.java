import Exception.CustomerValidationException;
import models.Category;
import models.CreditCardManager;
import models.Customer;
import models.Transaction;
import org.junit.jupiter.api.Test;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TransactionTest {


    @Test
    void shouldAbleToInitialiseTransactionForCustomerId() throws CustomerValidationException {
        Customer customer = Customer.createCustomer(1, "xyz", "rahulbasutkar@gmail.com");
        boolean creditCardAssigned = CreditCardManager.assignCard(customer);
        boolean expected = false;
        if (creditCardAssigned) {
            Transaction transaction = new Transaction(customer.getId());
            expected = transaction.perform(Category.BOOKS, 1200, Month.MARCH);

            transaction.perform(Category.GROCERY, 1000, Month.MARCH);
            transaction.perform(Category.ELECTRONICS, 800, Month.MARCH);
        }
        assertTrue(expected);
    }

    @Test
    void shouldAbleToInitialiseTransactionForCustomerSecond() throws CustomerValidationException {
        Customer customer = Customer.createCustomer(2, "Abc", "rahulbasutkar33@gmail.com");
        boolean creditCardAssigned = CreditCardManager.assignCard(customer);
        boolean expected = false;
        if (creditCardAssigned) {
            Transaction transaction = new Transaction(customer.getId());
            expected = transaction.perform(Category.BOOKS, 800, Month.MARCH);

            transaction.perform(Category.GROCERY, 500, Month.MARCH);
            transaction.perform(Category.ELECTRONICS, 200, Month.MARCH);
        }
        assertTrue(expected);
    }


}