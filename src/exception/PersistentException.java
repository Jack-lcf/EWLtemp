package exception;

public class PersistentException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * default constructor PersistentException
     */
    public PersistentException() {
    }

    /**
     * constructor PersistentException specifying number of objects to create
     * 
     * @param message
     * @param cause
     */
    public PersistentException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * constructor PersistentException specifying number of objects to create
     * 
     * @param message
     */
    public PersistentException(String message) {
        super(message);
    }

    /**
     * constructor PersistentException specifying number of objects to create
     * 
     * @param cause
     */
    public PersistentException(Throwable cause) {
        super(cause);
    }

}
