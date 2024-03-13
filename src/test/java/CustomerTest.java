import models.Customer;
import org.junit.jupiter.api.Test;

import javax.naming.InvalidNameException;
import  Exception.*;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void shouldAbleToCreateCustomer() throws CustomerValidationException {
        Customer.createCustomer(1,"Rahul","abc@gmail.com");

        assertEquals(1,Customer.getId());

    }
    @Test
    void shouldAbleToValidateUserIdAndThrowException()
    {
        assertThrows(InvalidCustomerIdException.class,()->{
            Customer.createCustomer(-1,"john doe","abc@gmail.com");
        });
    }


    @Test
    void shouldAbleTOThrowExceptionIfNameISNull()
    {
       Exception exception= assertThrows(InvalidCustomerNameException.class,()->{
           Customer.createCustomer(1,null,"abc@gmail.com");
        });
        System.out.println(exception.getMessage());
    }

    @Test
    void shouldAbleToThrowExceptionIfEmailIsNull()
    {
        Exception exception=assertThrows(InvalidEmailException.class,()->{
            Customer.createCustomer(1,"Rahul",null);
        });
    }











}