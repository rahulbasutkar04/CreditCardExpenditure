import models.Category;
import models.Customer;
import models.CreditCardManager;
import org.junit.jupiter.api.Test;
import Exception.*;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreditCardMangerTest {

    @Test
    void shouldAbleToCreateCustomer() throws CustomerValidationException {
        CreditCardManager creditCardManger = new CreditCardManager();
        Customer expected = Customer.createCustomer(1, "John Doe", "abc@gmail.com");
        Customer actual = creditCardManger.createCustomer(1, "John Doe", "abc@gmail.com");

        assertEquals(expected, actual);

    }

    @Test
    void shouldAbleToAssignCreditCardToUser() throws CustomerValidationException {
        CreditCardManager creditCardManager = new CreditCardManager();
        Customer customer = Customer.createCustomer(1, "John Doe", "abc@gmail.com");
        boolean isAssigned = creditCardManager.assignCard(customer);
        assertTrue(isAssigned);


    }

    @Test
    void shouldAbleToMakeTransactions() throws CustomerValidationException {

        CreditCardManager creditCardManager = new CreditCardManager();
         Customer.createCustomer(1, "John Doe", "abc@gmail.com");
        assertTrue(creditCardManager.MakeTransactions(Category.BOOKS, 1000.0, Month.MARCH));
        assertTrue(creditCardManager.MakeTransactions(Category.ELECTRONICS, 2000.0, Month.MARCH));
        assertTrue(creditCardManager.MakeTransactions(Category.CLOTHING, 800, Month.MARCH));
        assertTrue(creditCardManager.MakeTransactions(Category.GROCERY, 200.0, Month.MARCH));


    }
}

