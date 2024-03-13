import Validation.CustomerValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

    class CustomerValidationTest {

        @Test
        void ShouldAbleToCheckValidCustomerNames()
        {
            CustomerValidation customerValidation=new CustomerValidation();
            boolean actual=customerValidation.isValidName("rahul");
            assertTrue(actual);
            assertTrue( customerValidation.isValidName("rahul basutkar"));
            assertTrue(customerValidation.isValidName("RahulBasutkar"));
            assertTrue(customerValidation.isValidName("Rah bas"));







            assertFalse(customerValidation.isValidName("Rah_bas"));
            assertFalse(customerValidation.isValidName("     Rahbas"));
            assertFalse(customerValidation.isValidName(null));
            assertFalse(customerValidation.isValidName(""));
            assertFalse(customerValidation.isValidName("123"));
            assertFalse(customerValidation.isValidName("Ra"));
            assertFalse(customerValidation.isValidName("Rahul B."));
            assertFalse(customerValidation.isValidName("Rahul     Basutkar"));

        }

    }