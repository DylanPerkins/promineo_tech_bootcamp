package recipes.exception;

public class dbException extends RuntimeException{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

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
