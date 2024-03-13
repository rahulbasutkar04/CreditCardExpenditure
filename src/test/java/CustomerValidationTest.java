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
            assertTrue(customerValidation.isValidName("RAHUL BASUTKAR"));
            assertTrue(customerValidation.isValidName("RAHUL Sanjay Basutkar"));


            assertFalse(customerValidation.isValidName("RAHUL      Sanjay          Basutkar"));
            assertFalse(customerValidation.isValidName("1234"));
            assertFalse(customerValidation.isValidName("Rah_bas"));
            assertFalse(customerValidation.isValidName("     Rahbas"));
            assertFalse(customerValidation.isValidName(null));
            assertFalse(customerValidation.isValidName(""));
            assertFalse(customerValidation.isValidName("123"));
            assertFalse(customerValidation.isValidName("Ra"));
            assertFalse(customerValidation.isValidName("Rahul B."));
            assertFalse(customerValidation.isValidName("Rahul     Basutkar"));
            assertFalse(customerValidation.isValidName("Rahul     Basutkar123"));
            assertFalse(customerValidation.isValidName("RahulBasutkar123"));
            assertFalse(customerValidation.isValidName("RahulBasutkar12  3    123"));
            assertFalse(customerValidation.isValidName("RahulBasutkar12  vasant  Basutkar"));


        }

        @Test
        void shouldAbleToValidEmailAddresses()
        {
            CustomerValidation customerValidation=new CustomerValidation();


            assertTrue(customerValidation.isValidEmail("rahulbasutkar33@gmail.com"));
            assertTrue(customerValidation.isValidEmail("rahulb@gmail.comm"));
            assertTrue(customerValidation.isValidEmail("rahulb123@gmail.comm"));
            assertTrue(customerValidation.isValidEmail("user@example.com"));
            assertTrue(customerValidation.isValidEmail("user.name@example.com"));
            assertTrue(customerValidation.isValidEmail("user123@example-domain.com"));
            assertTrue(customerValidation.isValidEmail("user-name@example.co.uk"));



            assertFalse(customerValidation.isValidEmail("user@localhost"));
            assertFalse(customerValidation.isValidEmail("user@.com"));
            assertFalse(customerValidation.isValidEmail("@example.com"));
            assertFalse(customerValidation.isValidEmail("user@example."));
            assertFalse(customerValidation.isValidEmail("rahulb12gmail.com"));
            assertFalse(customerValidation.isValidEmail("user@example.com."));
            assertFalse(customerValidation.isValidEmail("user@example..com"));
            assertFalse(customerValidation.isValidEmail("user@example..co.uk"));
            assertFalse(customerValidation.isValidEmail("user@example.."));
            assertFalse(customerValidation.isValidEmail("user@123"));
            assertFalse(customerValidation.isValidEmail("user@-"));
            assertFalse(customerValidation.isValidEmail("user@."));
            assertFalse(customerValidation.isValidEmail("user@"));
            assertFalse(customerValidation.isValidEmail(""));







        }

    }