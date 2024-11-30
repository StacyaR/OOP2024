package ru.vsu.cs.sem3.oop.practice.exceptions;

public class ListenerRuleViolationException extends RuntimeException {
    private String message;

    public ListenerRuleViolationException() {
    }

    public ListenerRuleViolationException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
