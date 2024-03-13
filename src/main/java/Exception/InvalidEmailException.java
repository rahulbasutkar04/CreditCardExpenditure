package Exception;

public class InvalidEmailException extends CustomerValidationException {
    public InvalidEmailException(String message) {
        super(message);
    }
}
