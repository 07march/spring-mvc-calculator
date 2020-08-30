package by.learn;

public class UserNorFoundException extends RuntimeException {
    public UserNorFoundException() {
    }

    public UserNorFoundException(String message) {
        super(message);
    }

    public UserNorFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNorFoundException(Throwable cause) {
        super(cause);
    }

    public UserNorFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
