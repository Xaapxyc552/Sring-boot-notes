package ua.skidchenko.Exceptions;

public class RetrievingDataFromNetException extends Exception{

    public RetrievingDataFromNetException(String message) {
        super(message);
    }

    public RetrievingDataFromNetException(String message, Throwable cause) {
        super(message, cause);
    }

    public RetrievingDataFromNetException(Throwable cause) {
        super(cause);
    }
}
