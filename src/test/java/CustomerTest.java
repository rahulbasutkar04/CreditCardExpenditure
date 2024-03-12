import org.junit.jupiter.api.Test;

import javax.sound.midi.InvalidMidiDataException;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void shouldAbleToValidateUserIdAndThrowException()
    {
        assertThrows(IllegalArgumentException.class,()->{
            Customer.createCustomer(-1,"john doe","abc@gmail.com");
        });
    }

//    @Test
//    void shouldAbleToThrowExceptionIfSameIdFound()
//    {
//        Customer.createCustomer(1,"John","cxy@gmail.com");
//        assertThrows(IllegalArgumentException.class,()->{
//            Customer.createCustomer(1,"John","cxy@gmail.com");
//        });
//    }    checked during assignment of creditcard






}