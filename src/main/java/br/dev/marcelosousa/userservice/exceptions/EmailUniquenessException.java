package br.dev.marcelosousa.userservice.exceptions;

public class EmailUniquenessException extends RuntimeException {
    public EmailUniquenessException(String message) {
        super(message);
    }
}
