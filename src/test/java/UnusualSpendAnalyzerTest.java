import models.*;
import org.junit.jupiter.api.Test;

import java.time.Month;
import Exception.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnusualSpendAnalyzerTest {

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
}
