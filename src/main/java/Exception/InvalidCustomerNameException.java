package Exception;

public class InvalidCustomerNameException extends CustomerValidationException {
    public InvalidCustomerNameException(String message) {
        super(message);
    }
}
