package projects.exception;

@SuppressWarnings("serial")
public class dbException extends RuntimeException {

    public dbException(String message) {
        super(message);
    }

    public dbException(String message, Throwable cause) {
        super(message, cause);
    }

    public dbException(Throwable cause) {
        super(cause);
    }

    public dbException() {
    }
}
