package main.rest.exception;

public class ValidationException extends RuntimeException {
    public ValidationException(String msg){
        super(msg);
    }
}
