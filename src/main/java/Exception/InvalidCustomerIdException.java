package Exception;

public class InvalidCustomerIdException extends CustomerValidationException {
    public InvalidCustomerIdException(String message) {
        super(message);
    }
}
