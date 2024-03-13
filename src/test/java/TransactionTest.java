import models.Customer;
import models.Transaction;
import models.CreditCardManager;
import org.junit.jupiter.api.Test;

import java.time.Month;
import Exception.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TransactionTest {

    @Test
    void shouldAbleToInitialiseTransactionForCustomerId() throws CustomerValidationException {
        Customer customer=Customer.createCustomer(1,"xyz","abc@123");
        boolean creditCardManager= CreditCardManager. assignCard(customer);
        boolean expected=false;
        if(creditCardManager)
        {
            Transaction transaction=new Transaction(Customer.getId());
             expected= transaction.perform("Grocery",1200, Month.MARCH);
        }

        assertTrue(expected);

    }

}